/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function SortNode(xmlFile, xslFile, cate) {
    new_xmlDOM = null;
    if (window.XMLHttpRequest) {
        //code for IE7+, Firefox, Chrome, Opera, Safari
        var xmlhttp = new XMLHttpRequest();

    }
    else {
        //code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("GET",xmlFile, false);
    xmlhttp.send();
    var xmlDOM = xmlhttp.responseXML;
    
    new_xmlDOM = '<Allproduct xmlns:pro="http://xml.netbeans.org/schema/Products">';
    
    searchNode()
  
}

