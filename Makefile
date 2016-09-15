bumpMajor:
	./gradlew bumpMajor genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag

bumpMinor:
	./gradlew bumpMinor genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag

bumpPatch:
	./gradlew bumpPatch genReadMe
	git add . && git commit -m "version++"
	./gradlew genTag
