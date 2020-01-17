$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/tests/cucumber/features/LoginCandidate.feature");
formatter.feature({
  "name": "Candidate Successful Login Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login the app successfully as a candidate",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Candidate"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"5910000010\" as my telephone number",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iFillAsMyTelephoneNumber(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Giriş Yap button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iClickGirişYapButton()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login the app successfully as a candidate2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Candidate"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I fill \"9210564322\" as my telephone number",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iFillAsMyTelephoneNumber(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Giriş Yap button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iClickGirişYapButton()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});