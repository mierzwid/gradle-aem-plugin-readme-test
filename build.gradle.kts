plugins {
    id("com.cognifide.aem.bundle")
    id("com.cognifide.aem.instance")
    id("com.cognifide.aem.tooling")
    id("com.neva.fork")
    id("java") // or any other like 'java' to compile OSGi bundle
}

group = "com.cognifide.gap"
version = "1.0-SNAPSHOT"

defaultTasks = listOf(":aemSatisfy", ":aemDeploy")

aem {
    config {
        packageRoot = "${aem.project.file("src/main/content")}"
        // ...

    }
    tasks {
        compose {
            fromProject(":core")
            System.currentTimeMillis()
            fromProject(":config")
        }
        bundle {
            javaPackage = "com.cognifide.gap"
            category = "example"
            vendor = "Cognifide"
        }
        satisfy {
            packages {
                url("http://.../package.zip")
            }
        }
    }
}

