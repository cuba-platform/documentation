document.addEventListener("DOMContentLoaded", function() {
  $('.ulist[id]').each(function(){
   this.insertBefore(createLinkAnchor(this.id), this.firstChild);
  });

  $('.dlist[id]').each(function(){
   this.insertBefore(createLinkAnchor(this.id), this.firstChild);
  });

  $('.paragraph[id]').each(function(){
    var pTagElements = this.getElementsByTagName('p');
    if(pTagElements.length == 1){
      var pTag = pTagElements[0];
      if(pTag.childNodes.length == 1){
         if(pTag.childNodes[0].nodeName == 'STRONG'){
            this.insertBefore(createLinkAnchor(this.id), this.firstChild);
           }
         }
       }
  });

  function createLinkAnchor(localLink){
    var aTag = document.createElement("a");
    aTag.className = "anchor";
    aTag.href = "#" + localLink;
    return aTag;
   }
});