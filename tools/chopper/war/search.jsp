<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>    
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@ page import="chopper.server.Search,chopper.server.SearchResult" %>
<%!
	Search search = null;
	
	public void jspInit() { 
		try {
			System.out.println("Loading index from /WEB-INF/index.txt");
			search = new Search(getServletContext().getResourceAsStream("/WEB-INF/index.txt"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error initializing JSP: " + e);
		}
	}

%>
<%
String searchTerms = request.getParameter("searchTerms");
String htmlSearchTerms = StringEscapeUtils.escapeHtml4(searchTerms);
long start = System.currentTimeMillis();
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>{{searchResultsTitle}} <%= htmlSearchTerms %></title>
    <link rel="stylesheet" href="./styles/cuba.css">
    <link rel="stylesheet" href="./styles/chopper.css">
    <link rel="stylesheet" href="./styles/coderay-asciidoctor.css">
</head>
<body class="book toc2 toc-left">
<div id="header">
    <div id="toc" class="toc2">
        <form action="search.jsp" class="search">
            <input type="text" name="searchTerms" value="<%= htmlSearchTerms %>" autofocus>
            <input type="submit" value="{{search}}">
        </form>
        {{toc}}
    </div>
    <div id="top">
        <div id="title">{{title}}</div>
        <div id="version">{{version}}</div>
        <div id="copyright">{{copyright}}</div>
    </div>
</div>
<div id="content">
    <div id="search-results">
<%
	if (searchTerms == null || searchTerms.trim().equals("")) {
		out.println("<p>{{searchTermIsEmpty}}</p>");
	} else if (searchTerms.length() < 3) {
		out.println("<p>{{searchTermIsTooShort}}</p>");
	} else {
		List<SearchResult> results = search.search(searchTerms);
		out.println("<p>" + results.size() + " {{searchResultsMsg}} " + htmlSearchTerms + "</p>");
		for (SearchResult result : results) {
			%>
			<div class="res">
				<div class="res-name">
					<a href="<%= result.fileName %>"><span class="name"><%= result.captionName %></span></a>
				</div>
				<div class="res-path"><%= result.captionPath %> <%= result.captionName %></div>
				<%
					for (String hit : result.hits) {
						out.println(hit);
					}
				%> 
			</div>
			<%	
		}
		System.out.println("Search for '" + htmlSearchTerms + "' completed in " + (System.currentTimeMillis() - start) + "ms");
	}
%>
	</div>
</div>
</body>
</html>