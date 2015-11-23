<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Momow Home Page</title>
        
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>       
        <script src="js/jquery-1.11.3.js"></script>
        <link href="css/jquery-ui.css" rel="stylesheet">
	<script src="external/jquery/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
	
        <script>
    
        $(function () {
   
        var change_img_time = 5000;	
        var transition_speed = 300;
    
        var simple_slideshow = $("#sliderUL"),
        listItems = simple_slideshow.children('li'),
        listLen	= listItems.length,
        i= 0,
		
        changeList = function () {
            listItems.eq(i).fadeOut(transition_speed, function () {
		i += 1;
		if (i === listLen) {
                    i = 0;
		}
		listItems.eq(i).fadeIn(transition_speed);
            });
        };
		
        listItems.not(':first').hide();
        setInterval(changeList, change_img_time);
	
        });
            
	</script>
       
    </head>
    <body>
        <div class="container">
        <div id="header">    
        <div id="logo">
            <h1><a id="top">momow Home</a></h1>
            <p> the Great Mower</p>
            
	</div>
        </div>
        <div id="menu">
            <ul>
                <li><a href="main?action=home">Home</a></li>
	        <li><a href="main?action=about">About Us</a></li>
                <li><a href="main?action=contact">Contact Us</a></li>
	        <li><a href="main?action=registration">Registration</a></li>
                <li><a href="main?action=login">Login</a></li>
            </ul>
        </div>
            
        <div id="bodyplus">
        <p><a href="main?action=member">Member</a></p>



   
        
        <table class="tableslider">
            <tr><td>
            <ul id="sliderUL">
                <li class="test"><img class="slide" src="pics/351.JPG" alt="" /></li>
                <li class="test"><img class="slide" src="pics/352.JPG" alt="" /></li>
                <li class="test"><img class="slide" src="pics/353.JPG" alt="" /></li>
                <li class="test"><img class="slide" src="pics/354.JPG" alt="" /></li>
            </ul>    
        </td></tr>
        </table>
        <br>
        <div class="footer">
         glenn.schmidt@g.austincc.edu
        </div>
        </div>
        </div>
    </body>
</html>

    





