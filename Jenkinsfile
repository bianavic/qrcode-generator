node {
  stage("Clone project") {
    git branch: 'main', url: 'https://github.com/bianavic/qrcode-generator.git'
  }

  stage("Build project with test execution") {
    sh "./gradlew build"
  }
}