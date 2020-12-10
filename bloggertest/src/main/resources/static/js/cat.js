 var catx=document.getElementsByClassName("cat")[0].offsetLeft;
    var pL=document.getElementById("pL");
    var pR=document.getElementById("pR");
    var r=17;

    document.onmousemove=function(ev) {
        var e = ev || event;
        var m=[];
        m.x=e.clientX-catx;  //鼠标坐标能落在左边等位置
        m.y=e.clientY-170;   //head_content、head、eye离上方的距离，使鼠标能落在上方区域
        var s=[];
        s.x=pL.offsetLeft;
        s.y=pL.offsetTop;
        var mosx = Math.abs(m.x - s.x);
        var mosy = Math.abs(m.y - s.y);
        var angle = Math.atan(mosy / mosx);
        var cx = 0, cy = 0;
        if (m.x >= s.x && m.y <= s.y) {
            cx = Math.cos(angle) * r;
            cy = Math.sin(angle) * -r;
//            console.log("右下");
        }
        if (m.x < s.x && m.y < s.y) {
            cx = Math.cos(angle) * -r;
            cy = Math.sin(angle) * -r;
//            console.log("左下");
        }
        if (m.x < s.x && m.y > s.y) {
            cx = Math.cos(angle) * -r;
            cy = Math.sin(angle) * r;
//            console.log("左上");
        }
        if (m.x > s.x && m.y > s.y) {
            cx = Math.cos(angle) * r;
            cy = Math.sin(angle) * r;
//            console.log("右上");
        }

        if((m.x+catx)>=catx && (m.x+catx)<=(catx+345) && (m.y+170)>=100 && (m.y+170)<=360){
            pL.style.top =15+'px';
            pR.style.top =15+'px';
            pL.style.left =18+'px';
            pR.style.left =18+'px';
        }else{
            pL.style.top = 15+ cy + 'px';
            pR.style.top = 15+ cy + 'px';
            pL.style.left =17+cx + 'px';
            pR.style.left =17+cx + 'px';
        }
    }