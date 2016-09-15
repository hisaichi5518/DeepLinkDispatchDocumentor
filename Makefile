bumpMajor:
	./gradlew bumpMajor genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag
	make release

bumpMinor:
	./gradlew bumpMinor genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag
	make release

bumpPatch:
	./gradlew bumpPatch genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag
	make release

release:
	./gradlew clean build bintrayUpload -PbintrayUser=hisaichi5518 -PbintrayKey=${BINTRAY_KEY} -PdryRun=false
