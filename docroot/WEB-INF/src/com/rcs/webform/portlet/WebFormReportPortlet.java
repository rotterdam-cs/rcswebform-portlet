package com.rcs.webform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.webform.common.JsonResponse;
import com.rcs.webform.common.dto.FormsDataDTO;
import com.rcs.webform.common.util.EntityDtoConverter;
import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.entity.dto.SubmittedDataDTO;
import com.rcs.webform.model.Form;
import com.rcs.webform.model.FormItem;
import com.rcs.webform.model.SubmittedData;
import com.rcs.webform.service.FormItemLocalServiceUtil;
import com.rcs.webform.service.FormLocalServiceUtil;
import com.rcs.webform.service.SubmittedDataLocalServiceUtil;

/**
 * Portlet implementation class WebFormReportPortlet
 */
public class WebFormReportPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(WebFormReportPortlet.class);
	
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		JsonResponse jsonResponse = new JsonResponse();
		PortletPreferences preferences = renderRequest.getPreferences();
		FormsDataDTO formsDataDto = new FormsDataDTO();
		FormDTO formDto = new FormDTO();
		List<SubmittedDataDTO> submittedDataDTOList = new ArrayList<SubmittedDataDTO>();
		Long formId = GetterUtil.getLong(preferences.getValue("selectedForm", "-1"));
		try {
			Form form = FormLocalServiceUtil.getFormByFormId(formId);
            List<FormItem> formItems = FormItemLocalServiceUtil.getFormItemsByFormId(form.getFormId());

            formDto = EntityDtoConverter.formEntityToDto(form, formItems, renderRequest.getLocale());
			
			List<SubmittedData> submittedDataList = SubmittedDataLocalServiceUtil.getSubmittedDataByForm(formId);
			
			for (SubmittedData submittedData : submittedDataList){
				submittedDataDTOList.add(EntityDtoConverter.submittedDataEntityToDTO(submittedData));
			}
			
			jsonResponse.setSuccess(true);
		} catch (Exception e) {
			jsonResponse.setSuccess(false);
			jsonResponse.setMessage("An error is occured when generating submitted data");
		}
		formsDataDto.setFormDto(formDto);
		formsDataDto.setDataDtoList(submittedDataDTOList);
		jsonResponse.setData(formsDataDto);
		renderRequest.setAttribute("data", jsonResponse);
		
		super.doView(renderRequest, renderResponse);
	}
}
