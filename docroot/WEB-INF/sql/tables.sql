create table rcswebform_Form (
	formId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	formAttrId VARCHAR(75) null,
	formAttrClass VARCHAR(75) null,
	title VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	useCaptcha BOOLEAN,
	successMessage VARCHAR(75) null,
	successURL VARCHAR(75) null,
	submitLabel VARCHAR(75) null,
	submitAttrId VARCHAR(75) null,
	submitAttrClass VARCHAR(75) null
);

create table rcswebform_FormItem (
	formItemId LONG not null primary key,
	formId LONG,
	formItemAttrId VARCHAR(75) null,
	formItemAttrClass VARCHAR(75) null,
	label VARCHAR(75) null,
	labelAttrId VARCHAR(75) null,
	labelAttrClass VARCHAR(75) null,
	inputAttrId VARCHAR(75) null,
	inputAttrClass VARCHAR(75) null,
	type_ VARCHAR(75) null,
	options VARCHAR(75) null,
	mandatory BOOLEAN,
	defaultValue VARCHAR(75) null,
	order_ INTEGER,
	validationType VARCHAR(75) null,
	validationRegexValue VARCHAR(75) null,
	errorValidationMessage VARCHAR(75) null,
	errorMandatoryMessage VARCHAR(75) null,
	hintMessage VARCHAR(75) null
);

create table rcswebform_FormToPorletMap (
	formToPorletMapId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	formId LONG,
	portletId VARCHAR(75) null
);