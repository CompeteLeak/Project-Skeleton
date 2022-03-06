var link = "https://public-api.tracker.gg/v2/apex/standard/profile/psn/L0ewki_";
function httpGet(link) {
  let xmlHttpReq = new XMLHttpRequest();
  xmlHttpReq.open("GET", link, false); 
  xmlHttpReq.send(null);

  return xmlHttpReq.responseText;
}
