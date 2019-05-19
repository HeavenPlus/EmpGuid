$(function(){
	var nav=document.getElementById("left_banner");
	var oNav=nav.getElementsByTagName("li");
	var oDiv=document.getElementsByClassName("tab");
	for(var i=0;i<oNav.length;i++){
		oNav[i].index=i;
		oNav[i].onmouseover=function () {
			for(var i=0;i<oNav.length;i++){
				oNav[i].className='';
				oDiv[i].style.display="none";
			}
			this.className='act';
			oDiv[this.index].style.display="block"
		}
		for(var m=1;m<oNav.length;m++){
			oNav[m].className='';
			oDiv[m].style.display="none";
		}
	}
})