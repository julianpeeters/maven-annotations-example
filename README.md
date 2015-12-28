# maven-annotations-example
Demonstration of file path error when annotations are in child projects, courtesy Raj Kumar


	> mvn compile
	...
	ERROR] /Users/kumar/tmp/child/src/main/scala/AvroCaseClasses.scala:9: exception during macro expansion:
	java.io.FileNotFoundException: src/main/scala/SkuRecord.avsc (No such file or directory)
	    at java.io.FileInputStream.open(Native Method)
	    at java.io.FileInputStream.<init>(FileInputStream.java:138)
	    at org.codehaus.jackson.JsonFactory.createJsonParser(JsonFactory.java:504)
	    at org.apache.avro.Schema$Parser.parse(Schema.java:922)
	    at com.julianpeeters.avro.annotations.util.SchemaParser$.getSchema(SchemaParser.scala:20)
	    at com.julianpeeters.avro.annotations.AvroTypeProviderMacro$.impl(TypeProviderMacro.scala:23)

	[ERROR] @AvroTypeProvider("src/main/scala/SkuRecord.avsc")
	[ERROR]  ^
	[ERROR] /Users/kumar/tmp/child/src/main/scala/AvroCaseClasses.scala:10: ambiguous reference to overloaded definition,
	....
	......
	....


	> cd child
	child> mvn compile
	...
	BUILD SUCCESS
	....


	child > mvn scala:run -DmainClass=com.jp.AvroCaseClasses
	...
	{"skuKey": "sku", "taxonomyId": 10, "alternateTaxonomyIds": [2, 10], "name": "typea", "brand": "branda", "description": "desca", "generatedSearchPhrases": ["item1", "item2"]}
	...

