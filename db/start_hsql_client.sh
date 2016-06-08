# java -cp ~/.m2/repository/org/hsqldb/sqltool/2.3.2/sqltool-2.3.2.jar: org.hsqldb.cmdline.SqlTool --rcFile sqltool.rc localhost-mydb --debug

#~/.m2/repository/org/hsqldb/sqltool/2.3.2/sqltool-2.3.2.jar
#:~/.m2/repository/org/hsqldb/hsqldb/2.3.2/hsqldb-2.3.2.jar
#org.hsqldb.cmdline.SqlTool

java -cp sqltool-2.3.2.jar:hsqldb-2.3.2.jar org.hsqldb.cmdline.SqlTool --rcFile sqltool.rc localhost-mydb