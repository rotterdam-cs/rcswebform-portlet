create table rcswebform_Form (
	formId LONG not null primary key,
	active_ BOOLEAN,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	formAttrId VARCHAR(75) null,
	formAttrClass VARCHAR(75) null,
	title STRING null,
	desc_ STRING null,
	useCaptcha BOOLEAN,
	successMessage STRING null,
	successURL VARCHAR(75) null,
	submitLabel STRING null,
	submitAttrId VARCHAR(75) null,
	submitAttrClass VARCHAR(75) null
);

create table rcswebform_FormItem (
	formItemId LONG not null primary key,
	active_ BOOLEAN,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	formId LONG,
	formItemAttrId VARCHAR(75) null,
	formItemAttrClass VARCHAR(75) null,
	label STRING null,
	labelAttrId VARCHAR(75) null,
	labelAttrClass VARCHAR(75) null,
	inputAttrId VARCHAR(75) null,
	inputAttrClass VARCHAR(75) null,
	type_ VARCHAR(75) null,
	mandatory BOOLEAN,
	defaultValue STRING null,
	order_ INTEGER,
	validationType VARCHAR(75) null,
	validationRegexValue STRING null,
	minLength INTEGER,
	maxLength INTEGER,
	errorValidationMessage STRING null,
	errorMandatoryMessage STRING null,
	errorLengthMessage STRING null,
	hintMessage STRING null
);

create table rcswebform_FormItemOption (
	formItemOptionId LONG not null primary key,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	formItemId LONG,
	optionKey VARCHAR(75) null,
	optionValue STRING null
);

create table rcswebform_FormItemOptions (
	formitemoptionsId LONG not null,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	formItemId LONG not null,
	optionKey STRING null,
	optionValue STRING null,
	primary key (formitemoptionsId, formItemId)
);

create table rcswebform_FormToPorletMap (
	formToPorletMapId LONG not null primary key,
	active_ BOOLEAN,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	formId LONG,
	portletId VARCHAR(75) null
);

create table rcswebform_SubmittedData (
	submittedDataId LONG not null,
	groupId LONG,
	companyId LONG,
	active_ BOOLEAN,
	creationDate DATE null,
	modificationDate DATE null,
	modificationUser VARCHAR(75) null,
	formId LONG not null,
	portletId VARCHAR(75) not null,
	formItemId LONG not null,
	userInput STRING null,
	primary key (submittedDataId, formId, portletId, formItemId)
);