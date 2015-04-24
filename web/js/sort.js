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
    xmlhttp.open("GET", xmlFile, false);
    xmlhttp.send();
    var xmlDOM = xmlhttp.responseXML;

    new_xmlDOM = '<Allproduct xmlns:pro="http://xml.netbeans.org/schema/Products">';

    searchNode(xmlDOM, cate);
    new_xmlDOM += "</Allproduct>";
    if (document.implementation && document.implementation.createDocument) {
        // Mozilla
        var xsltProcessor = new XSLTProcessor();
        // load the xslt file
        var myXMLHTTPRequest = new XMLHttpRequest();
        myXMLHTTPRequest.open("GET", xslFile, false);
        myXMLHTTPRequest.send(null);
        // get the Xslt document
        xslStylesheet = myXMLHTTPRequest.responseXML;
        xsltProcessor.importStylesheet(xslStylesheet);
        // load the xml file
        if (window.DOMParser) {
            // alert("ccccc");
            parser = new DOMParser();
            xml = parser.parseFromString(new_xmlDOM, "text/xml");
            // alert(xml);
        } else // Internet Explorer
        {
            xml = new ActiveXObject("Microsoft.XMLDOM");
            xml.async = false;
            xml.loadXML(new_xmlDOM);
        }
        //alert(xsltProcessor);
        //transform
        var resultDocument = xsltProcessor.transformToFragment(xml, document);
        // alert(resultDocument);
        document.getElementById("result").innerHTML = "";
        document.getElementById("result").appendChild(resultDocument);
    }
    else if (window.ActiveXObject) {
        // IEelse if(window.ActiveXObject){
        alert("chay ben IE");
        // Load XML
        var xml = new ActiveXObject("Microsoft.XMLDOM");  //Microsoft.XMLDOM
        xml.async = false;
        xml.loadXML(new_xmlDOM);

        //        alert(xml);
        //        alert(xslFile);
        // Load XSL
        var xsl = new ActiveXObject("Microsoft.XMLDOM");
        xsl.async = false;
        xsl.load(xslFile);
        //        alert(xsl);

        // Transform   transformNode
        if (xml.parseError.errorCode != 0) {
            alert("XML loi");
            alert("Error1:" + xml.parseError.reason);
        } else if (xsl.parseError.errorCode != 0) {
            alert("Error2:" + xsl.parseError.reason);
        } else {
            var out = xml.transformNode(xsl);
            //                    alert(out);
            document.getElementById('result').innerHTML = out;
        }


        //        alert("transform IE");
        //        var out = xml.transformNode(xsl);
        alert(out);
        //        document.getElementById('result').innerHTML = out;
    }
}
function searchNode(node, strSort) {
    // search dung domtree trong firefox


    //alert("vao search node");
    strSort = strSort.toLowerCase();
    if (node == null) {
        alert("null");
        return;
    }

    if (node.tagName == "Category") {
        //alert("vao ham if");
        var tmp = node.firstChild.nodeValue.toLowerCase();
        // alert(tmp);
        if (tmp.indexOf(strSort, 0) > -1) {
            //  alert(tmp.indexOf(strSearch, 0));
            //            var preNode = node.nextSibling;
            //            alert(preNode.nodeValue);
            //            var preNode = node.nextSibling;
            //  alert(node.previousElementSibling.firstChild.nodeValue);
            //                        var preNode = node.nextSibling;
            //                        alert(preNode.firstChild.nodeName);
            var previous = node.previousElementSibling;
            var des = previous.firstChild.nodeValue;
            previous = previous.previousElementSibling;
            var price = previous.firstChild.nodeValue;
            previous = previous.previousElementSibling;
            var name = previous.firstChild.nodeValue;
            previous = previous.previousElementSibling;
            var PID = previous.firstChild.nodeValue;
            previous = previous.previousElementSibling;
            new_xmlDOM += "<productList>";
            new_xmlDOM += "<PID>" + PID + "</PID>";
            new_xmlDOM += "<Name>" + name + "</Name>";
            //alert(node.firstChild.nodeValue);
            var sibling = node.nextElementSibling;
            new_xmlDOM += "<Price>" + price + "</Price>";
            new_xmlDOM += "<Description>" + des + "</Description>";
            new_xmlDOM += "<Category>" + node.firstChild.nodeValue + "</Category>";
            new_xmlDOM += "<Image>" + sibling.firstChild.nodeValue + "</Image>";
            sibling = sibling.nextElementSibling;
            new_xmlDOM += "<Instock>" + sibling.firstChild.nodeValue + "</Instock>";
            new_xmlDOM += "</productList>";
        }
    }
    var childs = node.childNodes;
    for (var i = 0; i < childs.length; i++) {
        searchNode(childs[i], strSort);
    }
}



