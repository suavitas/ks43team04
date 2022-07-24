/*깃허브수정*/
$(document).ready(function(){
	
    //btn_reset 을 클릭했을때의 함수
    $( "#btn_reset").click(function () {
        $( "#reset_form" ).each( function () {
            this.reset();
        });
        $(".searchBtn").find('button').removeClass('btn-primary').addClass('btn-light');
    });
    
    $(document).on('click','button[name="filterDate"]', function(){
        console.log('1-1 btn-light == '+ $(this).hasClass('btn-light'));
        console.log('1-2 btn-primary == '+ $(this).hasClass('btn-primary'));
        
        
		if($(this).hasClass('btn-light') == true && $(this).hasClass('btn-primary') == false ){
			$('.searchBtn').find('button').removeClass('btn-primary');
			$(this).removeClass('btn-light').addClass('btn-primary');
		   
		}else if($(this).hasClass('btn-light') == false && $(this).hasClass('btn-primary') == false ){
			$('.searchBtn').find('button').removeClass('btn-primary');
			$(this).removeClass('btn-light').addClass('btn-primary');
		}else {
			$('.searchBtn').find('button').removeClass('btn-light');
			$(this).removeClass('btn-primary').addClass('btn-light');
		}
     });
    
    $(function() {
        /*$( ".datepicker" ).datepicker();*/
    	
    	$('#startDate').datepicker({
            onClose: function( selectedDate ) {    
                // 시작일(fromDate) datepicker가 닫힐때
                // 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                $("#startDate").datepicker( "option", "minDate", selectedDate );
            }                
        });

        //종료일
        $('#endDate').datepicker({
            onClose: function( selectedDate ) {
                // 종료일(toDate) datepicker가 닫힐때
                // 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
                $("#startDate").datepicker( "option", "maxDate", selectedDate );
            }                
        });
        
        
    });
    
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        prevText: '이전',
        nextText: '다음',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    
    $('.datepicker').datepicker({
	    beforeShow: function() {
	        setTimeout(function(){
	            $('.ui-datepicker').css('z-index', 99999999999999);
	        }, 0);
	    }
	});
    
    //오늘 버튼 클릭시 datePicker 오늘 검색
    $(function(){
    	const 
    	 current = 			moment().startOf('day')
    	,todayDate = 		moment(current).format('YYYY-MM-DD')
    	,todayDate2 = 		moment(current).format('YYYY-MM-DD')
    	,weekDate =  		moment(current, "YYYY-MM-DD").subtract(7, 'days').format('YYYY-MM-DD')
    	,monthDate = 		moment(current, "YYYY-MM-DD").subtract(1, 'months').format('YYYY-MM-DD')
    	,threeMonthDate = 	moment(current, "YYYY-MM-DD").subtract(3, 'months').format('YYYY-MM-DD')
    	,sixMonthDate = 	moment(current, "YYYY-MM-DD").subtract(6, 'months').format('YYYY-MM-DD')
    	,YearDate = 		moment(current, "YYYY-MM-DD").subtract(1, 'years').format('YYYY-MM-DD');
    	
    	
    	$('#btn-date1').click(function(){
    		$('#startDate').val(todayDate);
    		$('#endDate').val(todayDate2);
    		
    	});
    	
    	$('#btn-date2').click(function(){
    		
    		$('#startDate').val(weekDate);
    		$('#endDate').val(todayDate);
    	});
    	
    	$('#btn-date3').click(function(){
    		
    		$('#startDate').val(monthDate);
    		$('#endDate').val(todayDate);
    		
    	});
    	
    	$('#btn-date4').click(function(){
    		
    		$('#startDate').val(threeMonthDate);
    		$('#endDate').val(todayDate);
    	});
    	
    	$('#btn-date5').click(function(){
    		
    		$('#startDate').val(sixMonthDate);
    		$('#endDate').val(todayDate);
    	});
    	
    	$('#btn-date6').click(function(){
    		
    		$('#startDate').val(YearDate);
    		$('#endDate').val(todayDate);
    	});
    	
    });
    

    
    /*var date = new DATE();
    var date2 = new DATE();
    date.getFullYear();
    date.getMonth() + 1
    date.getDate()
    date2.setDate(date.getDate() - 7)
    date2.getDate()
    date2.setMonth(date.getMonth - 1);
    date.getMonth() + 1;*/
    
});


