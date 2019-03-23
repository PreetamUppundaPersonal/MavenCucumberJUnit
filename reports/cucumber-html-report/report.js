$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/sample.feature");
formatter.feature({
  "name": "Sample feature file",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sample"
    }
  ]
});
formatter.scenario({
  "name": "Sample selenium test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sample"
    }
  ]
});
formatter.step({
  "name": "Open browser",
  "keyword": "Given "
});
formatter.match({
  "location": "sample.open_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "test",
  "keyword": "When "
});
formatter.match({
  "location": "sample.test()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "result",
  "keyword": "Then "
});
formatter.match({
  "location": "sample.result()"
});
formatter.result({
  "status": "passed"
});
});