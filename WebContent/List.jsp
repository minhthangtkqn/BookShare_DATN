<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="common.*"%>

   <%
   
   try{
        String s[]=null;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShare";
		String userName = "sa";
		String password = "12345678";
		
     Connection connection = DriverManager.getConnection(url, userName, password);
     Statement st = connection.createStatement();
     ResultSet rs = st.executeQuery("SELECT TenSach from [tblRaoBan]");

       List li = new ArrayList();

       while(rs.next())
       {
           li.add(rs.getString(1));
       }

       String[] str = new String[li.size()];
       Iterator it = li.iterator();

       int i = 0;
       while(it.hasNext())
       {
           String p = (String)it.next();
           str[i] = p;
           i++;
       }

    //jQuery related start
       String query = (String)request.getParameter("q");
	   System.out.println("Tu khoa: " + query);
    
       int cnt=1;
       for(int j=0;j<str.length;j++)
       {
           //if(str[j].toUpperCase().startsWith(query.toUpperCase()))
           if(StringProcess.removeDiacritics(str[j]).toLowerCase().contains(StringProcess.removeDiacritics(query).toLowerCase()))
           {
              out.print(str[j]+"\n");
              if(cnt >= 5)// 5=How many results have to show while we are typing(auto suggestions)
              break;
              cnt++;
            }
       }
    //jQuery related end

rs.close();
st.close();
connection.close();

}
catch(Exception e){
e.printStackTrace();
}

//www.java4s.com
%>