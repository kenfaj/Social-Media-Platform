<%-- Document : admin Created on : 02 24, 25, 3:10:37 PM Author : ken --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Admin Home Page</title>
  </head>
  <body>
    <h1>Admin Home Page</h1>
    <div class="guests-block">
      <h2>List of Guests</h2>
      <table border="1">
        <!--TODO: Iterate through the list of guests using JDBCModel object and its function -->
        
        <tr>
          <th>User ID</th>
          <th>Username</th>
          <th>Messages</th>
        </tr>
        <tr>
          <td>1</td>
          <td>JohnDoe</td>
          <td>Hello John!</td>
        </tr>
        <tr>
          <td>2</td>
          <td>JaneSmith</td>
          <td>Your account has been updated.</td>
        </tr>
      </table>
    </div>
    <div class="admin-block">
      <h2>List of Admins</h2>
      <table border="1">
        <!--TODO: Idk paano yung message ng admin, kaya wait lang sa email-->
      </table>
    </div>

    <div>
      <button onclick="window.location.href='create.jsp'">Create User</button>
      <button onclick="window.location.href='update.jsp'">Update User</button>
      <button onclick="window.location.href='delete.jsp'">Delete User</button>
    </div>
  </body>
</html>
