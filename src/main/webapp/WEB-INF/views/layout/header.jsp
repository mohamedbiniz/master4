<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/7/20
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

      <!-- Static navbar -->
   <header>
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="${pageContext.request.contextPath}/article/">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/tag/">Tag</a></li>
              <li><a href="#">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
  </header>