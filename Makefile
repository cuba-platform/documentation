# If you system jave is not Java8 (such as you are using java 11, should specify the java 8 home path)
#   current wrapped gradle version cannot support java version > 8
JAVA_HOME=${HOME}/.sdkman/candidates/java/8.0.252-zulu
clean:
	./gradlew clean

manual-en-pdf:
	./gradlew buildManualEnPdf --debug

manual-ru-pdf:
	./gradlew buildManualRuPdf --debug

manual-en-html-single:
	./gradlew buildManualEn --debug
