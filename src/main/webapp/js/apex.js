function httpGet("https://public-api.tracker.gg/v2/apex/standard/profile/psn/L0ewki_") {
  let xmlHttpReq = new XMLHttpRequest();
  xmlHttpReq.open("GET", "https://public-api.tracker.gg/v2/apex/standard/profile/psn/L0ewki_", false); 
  xmlHttpReq.send(null);

  return xmlHttpReq.responseText;
}