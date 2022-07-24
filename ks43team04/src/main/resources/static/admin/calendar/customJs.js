$(function(){
            var today = new Date();
            var date = new Date();           
            
            function events (start, end, buildCalendar) {
                const data = {
                   startDate    : moment(start).format('YYYY-MM-DD'),
                   endDate      : moment(end).format('YYYY-MM-DD')
                };
                 $.ajax({
                   type: "POST",
                   url: "/calendar/selectHoliday",
                   dataType: 'JSON',
                   contentType: 'application/json; charset=utf-8',
                   data: JSON.stringify(data),
                   })
                .done(function (response) {
                	console.log(response);
                   buildCalendar(response);
                })
                .fail(function (e) {
                   console.log(e);
                })
             }
            
            $("input[name=preMon]").click(function() { // 이전달
                $("#calendar > tbody > td").remove();
                $("#calendar > tbody > tr").remove();
                today = new Date ( today.getFullYear(), today.getMonth()-1, today.getDate());
                events(new Date(nowYear,nowMonth - 1 ,1).getDate(), new Date(nowYear,nowMonth,0).getDate(), buildCalendar);
            })
            
            $("input[name=nextMon]").click(function(){ //다음달
                $("#calendar > tbody > td").remove();
                $("#calendar > tbody > tr").remove();
                today = new Date ( today.getFullYear(), today.getMonth()+1, today.getDate());
                events(new Date(nowYear,nowMonth + 1 ,1).getDate(), new Date(nowYear,nowMonth + 2,0).getDate(), buildCalendar);
            })


            function buildCalendar(holidayList) {
                
                nowYear = today.getFullYear();
                nowMonth = today.getMonth();
                firstDate = new Date(nowYear,nowMonth,1).getDate();
                firstDay = new Date(nowYear,nowMonth,1).getDay(); //1st의 요일
                lastDate = new Date(nowYear,nowMonth+1,0).getDate();

                if((nowYear%4===0 && nowYear % 100 !==0) || nowYear%400===0) { //윤년 적용
                    lastDate[1]=29;
                }

                $(".year_mon").text(nowYear+"년 "+(nowMonth+1)+"월");

                for (i=0; i<firstDay; i++) { //첫번째 줄 빈칸
                    $("#calendar tbody:last").append("<td></td>");
                }
                
                var holidayIdx = 0;
                for (i=1; i <=lastDate; i++){ // 날짜 채우기
                    newDate = new Date(nowYear,nowMonth,i);
                    plusDate = newDate.getDay();
    
                    day = newDate.toISOString().substring(0,10);
                    
                    if (plusDate==0) {
                        $("#calendar tbody:last").append("<tr></tr>");
                    }
                    for(var j = 0; j < holidayList.length; j++) {

                    	if(day == holidayList[j].yearlyHolidayDate) {
                    		holidayIdx = 1;
                    	}
                    }
                    
            
                    if(holidayIdx > 0) {
                    	$("#calendar tbody:last").append("<td class='date holiday'>"+ i +"</td>");
                    }else{
                    	$("#calendar tbody:last").append("<td class='date'>"+ i +"</td>");
                    }
                    holidayIdx = 0;
                }
                if($("#calendar > tbody > td").length%7!=0) { //마지막 줄 빈칸
                    for(i=1; i<= $("#calendar > tbody > td").length%7; i++) {
                        $("#calendar tbody:last").append("<td></td>");
                    }
                }
                $(".date").each(function(index){ // 오늘 날짜 표시
                    if(nowYear==date.getFullYear() && nowMonth==date.getMonth() && $(".date").eq(index).text()==date.getDate()) {
                        $(".date").eq(index).addClass('colToday');
                    }
                }) 
            }
            
            events(moment().startOf('month').format('YYYY-MM-DD'), moment().endOf('month').format('YYYY-MM-DD'), buildCalendar);
            


        })