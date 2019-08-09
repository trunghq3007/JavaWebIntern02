function check(){
    var regex_phonenumber = /((09|03|07|08|05)+([0-9]{8})\b)/g;
    var regex_email = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

    var name = document.getElementById('name');
    var phone = document.getElementById('phone');
    var email = document.getElementById('email');
    var city = document.getElementById('ct');
    var graduation = document.getElementById('gr');
    var career = document.getElementById('cr');
    
    if(name.value == ''){
        document.getElementById("note").innerHTML = "<span>Bạn chưa nhập tên</span>";
    }

    else if(!regex_phonenumber.test(phone.value)){
        document.getElementById("note").innerHTML = "<span>Bạn chưa nhập đủ số điện thoại</span>";
    }

    else if(city.value == ''){
        document.getElementById("note").innerHTML = "<span>Bạn cần chọn nơi ở</span>";
    }

    else if(graduation.value == ''){
        document.getElementById("note").innerHTML = "<span>Bạn cần chọn cấp học đã tốt nghiệp</span>";
    }

    else if(career.value == ''){
        document.getElementById("note").innerHTML = "<span>Bạn cần chọn ngành học</span>";
    }

    else if(!regex_email.test(email.value)){
        document.getElementById("note").innerHTML = "<span>Bạn chưa nhập hoặc nhập sai email</span>";
    }

    else{
        document.getElementById("note").innerHTML = "<span>Bạn đã đăng ký thành công</span>";
    }

}

$(document).ready(function(){
    // Activate Carousel
    $("#myCarousel").carousel();
      
    // Enable Carousel Indicators
    $(".item1").click(function(){
      $("#myCarousel").carousel(0);
    });
    $(".item2").click(function(){
      $("#myCarousel").carousel(1);
    });
    $(".item3").click(function(){
      $("#myCarousel").carousel(2);
    });
    $(".item4").click(function(){
      $("#myCarousel").carousel(3);
    });
      
    // Enable Carousel Controls
    $(".left").click(function(){
      $("#myCarousel").carousel("prev");
    });
    $(".right").click(function(){
      $("#myCarousel").carousel("next");
    });
  });

