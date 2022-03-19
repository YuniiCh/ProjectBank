<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Se connecter</title>
        <SCRIPT LANGUAGE="JavaScript">
            function calendar() {
                let today = new Date();
                let year = today.getYear();
                let thisDay = today.getDate();

                let monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
                    monthDays[1] = 29;
                daysOfCurrentMonth = monthDays[today.getMonth()];
                firstDay = today;
                firstDay.setDate(1);
                startDay = firstDay.getDay();
                const dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
                let newDate = new Date();
                document.write("<TABLE BORDER='0' CELLSPACING='0' CELLPADDING='2' BGCOLOR='#F0D8A8'>")
                document.write("<TR><TD><table border='0' cellspacing='1' cellpadding='2' bgcolor='#FFF0A8'>");
                document.write("<TR><th colspan='7' bgcolor='#D8D8C0'>");
                document.writeln("<FONT STYLE='font-size:9pt;Color:#484848'>" + "We are " + newDate.getDate() + "/" + (newDate.getMonth() + 1) + "/" + (newDate.getYear() + 1900) + " " + dayNames[newDate.getDay()] + "</FONT>");
                document.writeln("</TH></TR><TR><TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Dimanche</FONT></TH>");
                document.writeln("<th bgcolor='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Lundi</FONT></TH>");
                document.writeln("<TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Mardi</FONT></TH>");
                document.writeln("<TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Mercredi</FONT></TH>");
                document.writeln("<TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Jeudi</FONT></TH>");
                document.writeln("<TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Vendredi</FONT></TH>");
                document.writeln("<TH BGCOLOR='#A8C0D8'><FONT STYLE='font-size:9pt;Color:White'>Samedi</FONT></TH>");
                document.writeln("</TR><TR>");
                let column = 0;
                for (let i = 0; i < startDay; i++) {
                    document.writeln(" <TD><FONT STYLE='font-size:9pt'> </FONT></TD>");
                    column++;
                }

                for (let i = 1; i <= daysOfCurrentMonth; i++) {
                    if (i == thisDay) {
                        document.writeln("</TD><TD ALIGN='CENTER'><FONT STYLE='font-size:9pt;Color:#ff0000'><B>")
                    } else {
                        document.writeln("</TD><TD BGCOLOR='#FFF0A8' ALIGN='CENTER'><FONT STYLE='font-size:9pt;font-family:Arial;font-weight:bold;Color:#484848'>");
                    }
                    document.writeln(i);
                    if (i == thisDay)
                        document.writeln("</FONT></TD>")
                    column++;
                    if (column == 7) {
                        document.writeln("<TR>");
                        column = 0;
                    }
                }
                document.writeln("<TR><TD COLSPAN='7' ALIGN='CENTER' VALIGN='TOP' BGCOLOR='#D8D8C0'>")
                document.writeln("<FORM NAME='time' onSubmit='0'><FONT STYLE='font-size:9pt;Color:#484848'>")
                document.writeln("<INPUT TYPE='Text' NAME='textbox' ALIGN='TOP'></FONT></TD></TR></TABLE>")
                document.writeln("</TD></TR></TABLE></FORM>");
            }

            function showtime() {
                var newDate = new Date();
                var hours = newDate.getHours();
                var minutes = newDate.getMinutes();
                var seconds = newDate.getSeconds()
                var timeValue = " " + ((hours > 12) ? hours - 12 : hours)
                timeValue += ((minutes < 10) ? ":0" : ":") + minutes
                timeValue += ((seconds < 10) ? ":0" : ":") + seconds
                timeValue += (hours >= 12) ? " PM " : " AM "
                document.time.textbox.value = timeValue;
                timerID = setTimeout("showtime()", 1000);
                timerRunning = true;
            }

            //montrer le temps
            function starttime() {
                showtime();
            }
        </SCRIPT>
        <link href="css/j.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="welcomepage" style='background-image: url("image/1.jfif")'>
        <h1>Welcome</h1>
        <div id="menu">
            <ul>
                <li><a href="WelcomePageCtrl?fct=banker">Banker</a></li>
                <li><a href="WelcomePageCtrl?fct=visitor">Visitor</a></li>
            </ul>

        </div>
        <div id="calendar">
            <SCRIPT LANGUAGE="JavaScript">
                calendar();
                starttime();
            </SCRIPT>
        </div>

        <div id="error">${requestScope.msg_erreur}</div>

    </body>
</html>