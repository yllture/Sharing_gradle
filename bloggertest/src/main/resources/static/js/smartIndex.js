;(function (window, undefined) {
  var treeView = tools.$('#treeView');
  var fileData = data.files;
  //alert(treeView);
  //alert(treeView);
  // 初始化
  treeView.innerHTML = treeHtml(fileData, null);
  
 
  // 事件
  var fileItem = tools.$('.treeNode');
  var root_icon = tools.$('.icon-control', fileItem[0])[0];
  root_icon.className = 'icon icon-control icon-add';

  tools.each(fileItem, function (item) {
    filesHandle(item);
  });

  function treeHtml(fileData, fileId) {
    var _html = '';
    var children = getChildById(fileData, fileId);
    var hideChild = fileId > null ? 'none' : '';

    _html += '<ul class="'+hideChild+'">';

    children.forEach(function (item, index) {
      var level = getLevelById(fileData, item.id);
      var distance = (level - 1) * 20 + 'px';
      var distance1 = (level - 1) * 20+4 + 'px';
      var hasChild = hasChilds(fileData, item.id);
      var className = hasChild ? '' : 'treeNode-empty';
      var treeRoot_cls = fileId === null ? 'treeNode-cur' : '';
      if(item.type==0){
	      _html += `
	        <li>
	          <div class="treeNode ${className} ${treeRoot_cls}" style="padding-left: ${distance}" data-file-id="${item.id}">
	            <i class="icon icon-control icon-add"></i>
	            <i class="icon icon-file"></i>
	            <span class="title">${item.title}</span>
	          </div>
	          ${treeHtml(fileData, item.id)}
	        </li>`;
      }else{
    	  _html += `
  	        <li>
  	          <div class="treeNode ${className} ${treeRoot_cls}" style="padding-left: ${distance1}" data-file-id="${item.id}">
    		  	<input type="checkbox" class="banklist-checkbox"/>

  	            <span class="title">${item.title}</span>
  	          </div>
  	          ${treeHtml(fileData, item.id)}
  	        </li>`;
      }
    });

    _html += '</ul>';

    return _html;
  };

  function filesHandle(item) {
    tools.addEvent(item, 'click', function () {
      var folderid=$(this).attr("data-file-id");
      var treeNode_cur = tools.$('.treeNode-cur')[0];
      var fileId = item.dataset.fileId;
      var curElem = document.querySelector('.treeNode[data-file-id="'+fileId+'"]');
      var hasChild = hasChilds(fileData, fileId);
      var icon_control = tools.$('.icon-control', item)[0];
      var openStatus = true;

      tools.removeClass(treeNode_cur, 'treeNode-cur');
      tools.addClass(curElem, 'treeNode-cur');

      if (hasChild) {
        openStatus = tools.toggleClass(item.nextElementSibling, 'none');

        if (openStatus) {
          icon_control.className = 'icon icon-control icon-add';
        } else {
          icon_control.className = 'icon icon-control icon-minus';
        }
      }
      
//	    $.ajax({
//	  	type :'post',
//	  	url:'smartBankList',
//  		data :{"folderid":folderid},
//	  	dataType:'text',
//	  	async:true,
//	  	contentType: "application/json; charset=utf-8",
//	  	success:function(msg){
//	  		var bankl=JSON.parse(msg);
//	  		var banklist=bankl.bklist;
//	  		alert(banklist.length);
//	  		var length=banklist.length;
//	  		for(var i=0;i<2;i++){
//	  			alert(banklist[i].bankname);
//			    var addfolderli=' ';
//			    addfolderli+="<li class='hover-item treeNode  treeNode-cur'><label>";
//			    addfolderli+="<input type='checkbox' class='banklist-checkbox' id='"+banklist[i].bankid+"' />"+banklist[i].bankname;
//			    addfolderli+="</label></li>";
//			    alert(addfolderli);
//			    //document.getElementById(folderid).appendChild(addfolderli);
//			    //$(this).next('ul').append(addfolderli);
//			    //alert($("#treeView"));
//			    //$("#treeView").append("ll");
//			    //alert(3);
//	  		}
//	  	}
//	  })
	  
    });
  };
})(window);