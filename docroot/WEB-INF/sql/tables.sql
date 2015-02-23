create table RcsWebform_WebformColumn (
	webformColumnId LONG not null primary key,
	webformTableId LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	inputType INTEGER,
	isRequired BOOLEAN,
	placeHolder VARCHAR(75) null,
	validation VARCHAR(75) null,
	customValidation VARCHAR(75) null,
	labelClass VARCHAR(75) null,
	inputClass VARCHAR(75) null,
	maxLength VARCHAR(75) null
);

create table RcsWebform_WebformRow (
	webformRowId LONG not null primary key,
	webformTableId LONG,
	updateDate DATE null
);

create table RcsWebform_WebformTable (
	webformTableId LONG not null primary key,
	portletId VARCHAR(75) null,
	webformCounter VARCHAR(75) null
);

create table RcsWebform_WebformValue (
	webformValueId LONG not null primary key,
	webformTableId LONG,
	webformColumnId LONG,
	webformRowId LONG,
	data_ LONG
);