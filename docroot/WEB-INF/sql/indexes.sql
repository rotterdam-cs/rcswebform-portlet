create index IX_5C95D339 on rcswebform_FormItem (formId);

create index IX_6046C555 on rcswebform_FormToPorletMap (groupId, companyId, portletId);
create index IX_315F9C53 on rcswebform_FormToPorletMap (portletId);