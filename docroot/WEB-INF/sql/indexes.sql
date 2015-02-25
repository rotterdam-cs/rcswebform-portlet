create index IX_BA4C5070 on RcsWebform_WebformColumn (webformTableId);

create index IX_92564DB6 on RcsWebform_WebformRow (webformTableId);

create index IX_947CFAE4 on RcsWebform_WebformTable (name);
create index IX_A167F320 on RcsWebform_WebformTable (portletId);
create index IX_4ED32858 on RcsWebform_WebformTable (portletId, webformCounter);

create index IX_FE340D4D on RcsWebform_WebformValue (webformTableId);