package com.neuedu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.Utils.DateUtils;
import com.neuedu.Utils.GroupCode;
import com.neuedu.Utils.ImgUtils;
import com.neuedu.Utils.MailUrlUtils;
import com.neuedu.dao.PaperMapper;
import com.neuedu.dao.PapermappingMapper;
import com.neuedu.entity.Adimin;
import com.neuedu.entity.Bank;
import com.neuedu.entity.Groupapply;
import com.neuedu.entity.Groupmember;
import com.neuedu.entity.GroupmemberKey;
import com.neuedu.entity.Groups;
import com.neuedu.entity.Homework;
import com.neuedu.entity.Paper;
import com.neuedu.entity.Shop_bank;
import com.neuedu.entity.User;
import com.neuedu.service.ExamService;
import com.neuedu.service.ExamrecordService;
import com.neuedu.service.GroupapplyService;
import com.neuedu.service.GroupmemberService;
import com.neuedu.service.GroupsService;
import com.neuedu.service.HomeworkService;
import com.neuedu.service.MailService;
import com.neuedu.service.PaperService;
import com.neuedu.service.UserService;

@Controller
public class GroupController {

	@Autowired
	GroupsService groupsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	GroupmemberService groupmemberService;
	
	@Autowired 
	HomeworkService homeworkService;
	@Autowired 
	PaperService paperService;
	
	@Autowired
	GroupapplyService groupapplyService;
	
	@Autowired
	ExamrecordService examrecordService;
	
	@Autowired
	MailService mailService;
	
	@Autowired 
	PapermappingMapper papermappingMapper;
	
	@Autowired
	PaperMapper papermapper;
	@Autowired
	ExamService examService;
//	@Autowired
//	GroupmemberKey groupmemberkeyService;
	
	//创建群还没加owner
	
	@RequestMapping("/toGroup")
	public String toGroup() throws IOException{
		return "group/teacher/indexteacher";
	}
	
	@RequestMapping("/toGroupList")
	public void toGroupList(HttpServletRequest request,HttpServletResponse res) throws IOException{
	    //System.out.println("11");
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		
		int userid=currentUser.getUserid();
		List<Groups> owngrouplist=groupsService.selectOwnGroups(userid);
		List<Groups> memgrouplist=groupmemberService.selectGroups(userid);
		Map<String, List<Groups>> map=new LinkedHashMap<String, List<Groups>>();		
		map.put("owngrouplist", owngrouplist);
		map.put("memgrouplist", memgrouplist);
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
		//return "group/teacher/indexteacher";
	}
//	@PostMapping("/getGroupsession")
//    @ResponseBody
	@RequestMapping("/getGroupsession")
	public void getGroupsession(@RequestParam("groupid") Integer groupid,HttpServletRequest request,HttpServletResponse res) throws IOException{
		
		
		HttpSession session=request.getSession();
		Groups group=groupsService.selectGroupsByGroupid(groupid);
		session.setAttribute("group", group);
		String msg="1";
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(msg);
	}
	@RequestMapping("/toAdminWork/{groupid}")
	public String toadminwork(@PathVariable Integer groupid,HttpServletRequest request){
//		System.out.println(groupid);
		HttpSession session=request.getSession();
		Groups group=groupsService.selectGroupsByGroupid(groupid);
		session.setAttribute("group", group);
		return "group/teacher/adminwork";
	}
	
	@RequestMapping("/AdminList")
	public void AdminList(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//System.out.println("oo");
		Groups group=(Groups) req.getSession().getAttribute("group");
		//System.out.println(group.getGroupid());
		int groupid=group.getGroupid();
		//拼接8需要  user type 从表groupapply获取申请人信息以及申请状态
	    List<Homework> homeworklist=homeworkService.selectHomeworkByGroupid(groupid);
	    //获取试卷信息
	    List<Paper> paperlist=homeworkService.selectPaperFromHomework(groupid);
	    //获取群主信息
	    User u=groupsService.selectOwnerFromGroup(groupid);
	    List<User> groupowner=new ArrayList<User>();
	    groupowner.add(u);
	    //获取群组成员
	    List<User> userlist=groupmemberService.selectUserEntity(groupid);
	    for(int i=0;i<userlist.size();i++) {
	    	System.out.println(userlist.get(i).getUsername());
	    }
	    for(Homework homework:homeworklist) {
	    	//System.out.println(homework.getPublishtime());
	    	String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(homework.getPublishtime());
//	    	System.out.println(date+"date");
	    	homework.setC1(date);
	    }
//	    for(Paper p:paperlist) {
//	    	//System.out.println(homework.getPublishtime());
//	    	String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(p.getBegintime());
////	    	System.out.println(date+"date");
//	    	p.setC1(date);
//	    	String date1= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(p.getEndtime());
////	    	System.out.println(date+"date");
//	    	p.setC4(date1);
//	    }
	    Map<String, List> map=new LinkedHashMap<String, List>();
	    map.put("homeworklist", homeworklist);
	    map.put("groupowner", groupowner);
	    map.put("userlist", userlist);
	    map.put("paperlist",paperlist);
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/toAdminDone")
	public String toAdminDone(@RequestParam(value="paperid",required=false) Integer paperid,HttpServletRequest request){
		//System.out.println(paperid);
		HttpSession session=request.getSession();
		session.setAttribute("paperid", paperid);
		return "suc";
	}
	
	@RequestMapping("/adminDone")
	public String adminDone(){
		//System.out.println("1");
		return "group/teacher/reviewDone";
	}
	
	@RequestMapping("/AdminDoneList")
	public void AdminDoneList(HttpServletRequest req,HttpServletResponse res) throws IOException, ParseException{
		Groups g=(Groups) req.getSession().getAttribute("group");
		int paperid=(int) req.getSession().getAttribute("paperid");
		System.out.println(paperid);
		//int paperid=6012;
		List<Paper> paperdone=paperService.selectAllPaperDone(paperid);
		List<User> userdone=paperService.selectAllUserDone(paperid);
		for(int i=0;i<paperdone.size();i++) {
			Date begindate=examrecordService.selectRelTime(paperdone.get(i).getPaperid()).getBegintime();
			String c1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(begindate);
			Date enddate=examrecordService.selectRelTime(paperdone.get(i).getPaperid()).getEndtime();
			String c2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(enddate);
			paperdone.get(i).setC1(c1);
			userdone.get(i).setC1(c2);
		}
		HashMap<String,List> map = new HashMap<String,List>();
		map.put("paperdone", paperdone);
		map.put("userdone", userdone);
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/toAdminUndo")
	public void toAdminUndo(@RequestParam(value="paperid",required=false) Integer paperid,HttpServletRequest request){
		//System.out.println(paperid);
		HttpSession session=request.getSession();
		session.setAttribute("paperid", paperid);
		
		//return "suc";
		//return "group/teacher/reviewDone";
	}
	
	@RequestMapping("/adminUndo")
	public String adminUndo(){
		//System.out.println("1");
		return "group/teacher/reviewUndo";
	}
	
	@RequestMapping("/AdminUndoList")
	public void AdminUndoList(HttpServletRequest req,HttpServletResponse res) throws IOException, ParseException{
		Groups g=(Groups) req.getSession().getAttribute("group");
		int paperid=(int) req.getSession().getAttribute("paperid");
		//int paperid=6012;
		List<Paper> paperdone=paperService.selectAllPaperUndo(paperid);
		List<User> userundo=paperService.selectAllUserUndo(paperid);
//		for(int i=0;i<paperdone.size();i++) {
//			Date begindate=examrecordService.selectRelTime(paperdone.get(i).getPaperid()).getBegintime();
//			String c1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(begindate);
//			Date enddate=examrecordService.selectRelTime(paperdone.get(i).getPaperid()).getEndtime();
//			String c2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(enddate);
//			paperdone.get(i).setC1(c1);
//			userdone.get(i).setC1(c2);
//		}
		HashMap<String,List> map = new HashMap<String,List>();
		map.put("paperdone", paperdone);
		map.put("userdone", userundo);
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/toMemberWork/{groupid}")  
	public String toMemberWork(HttpServletRequest request,@PathVariable Integer groupid){
	    //System.out.println("11");
		HttpSession session=request.getSession();
		Groups group=groupsService.selectGroupsByGroupid(groupid);
		session.setAttribute("group", group);
		return "group/teacher/memberwork";
	}
	
	@RequestMapping("/MemberList")
	public void MemberList(HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		User use=(User) req.getSession().getAttribute("currentUser");
		int groupid=group.getGroupid();
		//拼接8需要  user type 从表groupapply获取申请人信息以及申请状态
	    List<Homework> homeworklist=homeworkService.selectHomeworkByGroupid(groupid);
	    //获取试卷信息
	    List<Paper> paperlist=homeworkService.selectPaperFromHomework(groupid);
	    //获取群主信息
	    User u=groupsService.selectOwnerFromGroup(groupid);
	    List<User> groupowner=new ArrayList<User>();
	    groupowner.add(u);
	    //获取群组成员
	    List<User> userlist=groupmemberService.selectUserEntity(groupid);
	    List<Integer> ifdolist=homeworkService.selectIfDo(groupid,use.getUserid());
//	    for(int i=0;i<ifdolist.size();i++) {
//	    	System.out.println(ifdolist.size()+" "+ifdolist.get(i));
//	    }
	    for(Homework homework:homeworklist) {
	    	//System.out.println(homework.getPublishtime());
	    	String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(homework.getPublishtime());
	    	//System.out.println(date);
	    	homework.setC1(date);
	    }
//	    for(Paper paper:paperlist) {
//	    	System.out.println(paper.getPaperid());
//	    	System.out.println(paper.getBegintime());
//	    	String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(paper.getBegintime());
//	    	paper.setC1(date);
//	    	String date1= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(paper.getEndtime());
//	    	paper.setC4(date1);
//	    }
	    Map<String, List> map=new LinkedHashMap<String, List>();
	    map.put("homeworklist", homeworklist);
	    map.put("groupowner", groupowner);
	    map.put("userlist", userlist);
	    map.put("paperlist",paperlist);
	    map.put("ifdolist", ifdolist);
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/toAddMember")
	public String toAddMember(){
	    //System.out.println("11");
		return "group/teacher/addMember";
	}
	
//	//批量导入加群组 
//	@RequestMapping("/AddExcelMember")
//	public String AddExcelMember(MultipartHttpServletRequest request){
//		try {
//            //得到上传的文件
//            MultipartFile fileFile = request.getFile("file");
//            //转换成输入流
//            InputStream in = fileFile.getInputStream();
//    		HSSFWorkbook readWb = new HSSFWorkbook(in);
//    		//邮箱列表
//    		List<String> accountlist=new ArrayList<String>();
//            /*HSSFWorkbook readWb = new HSSFWorkbook(in);*/
//            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
//            for (int i = 0; i < readWb.getNumberOfSheets(); i++) {
//                HSSFSheet sheet = readWb.getSheetAt(i);
//                // 循环行Row
//                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//                    HSSFRow hssfRow = sheet.getRow(rowNum);
//                    if (hssfRow != null) {
//                        for (int colNum = 0; colNum < hssfRow.getPhysicalNumberOfCells(); colNum++) {
//                        	Cell cell=hssfRow.getCell(colNum);
//                        	accountlist.add(cell.getStringCellValue());
//                        	//System.out.println(hssfRow.getCell(colNum));
//                        }
//                        //赋值实例对象 做插入数据库操作
//                    }
//                }
//            }
//            
//            //通过账户列表获取userid
//            List<Integer> useridlist=new ArrayList<Integer>();
//            for(String account:accountlist) {
//            	User user=new User();
//            	user.setUseraccount(account);
//            	user=userService.selectUserByAccount(user);
//            	useridlist.add(user.getUserid());
//            }
//            
//            //将groupid和userid插入列表
//            
//            int groupid=1001;
//            Groupmember gm=new Groupmember();
//            for(Integer userid:useridlist) {
//            	gm.setGroupid(groupid);
//            	gm.setMemberid(userid);
//            	int i=groupmemberService.addMember(gm);
//            }
//           
//        } catch (Exception e) {
//           
//            e.printStackTrace();
//        }
//		return "group/teacher/addMember";
//	}
	//通过群码增加组员
	@RequestMapping("/AddMember")
	public void AddMember(@RequestParam(value="account",required=false,defaultValue="-1") String account,HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		//System.out.println(account);
		int groupid=group.getGroupid();
		//int userid;
		//通过account获取userid
		User user=new User();
    	user.setUseraccount(account);
    	user=userService.selectUserByAccount(user);
    	System.out.println(user.getUserid()+user.getUseraccount());
		//加入群成员表
    	Groupmember gm=new Groupmember();
        gm.setGroupid(groupid);
        gm.setMemberid(user.getUserid());
        int i=groupmemberService.addMember(gm);
        String msg;
        
		if(i==1) {
			msg="添加成功";
		}else {
			msg="添加失败";
		}
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(msg);
	}
	@RequestMapping("/toJoinGroup")
	public String toJoinGroup(){
	    //System.out.println("11");
		return "group/teacher/joinGroup";
	}
	
	//通过群码添加群组
		@RequestMapping("/JoinGroup")
		public void JoinGroup(@RequestParam(value="groupcode",required=false,defaultValue="-1") String groupcode,HttpServletResponse res,HttpServletRequest request) throws IOException{
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			
			int userid=currentUser.getUserid();
			//int userid;
			//获取申请时间
			Date date=new Date();
			String applytime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
			//System.out.println(applytime);
			//通过groupcode获取group
			User user=new User();
			Groups group=new Groups();
	    	group.setC1(groupcode);
	    	group=groupsService.selectGroupsByCode(groupcode);
	    	Groupmember gmtest=new Groupmember();
	    	gmtest.setMemberid(userid);
	    	gmtest.setGroupid(group.getGroupid());
	    	//获取判断群状态，判断直接加群还是
	    	int type=group.getType();
	    	String msg;
	    	int m=groupmemberService.ifContainInGroup(gmtest);
//	    	System.out.println(m+"这j");
	    	if(m==0) {
	    		msg="添加失败，你已是群成员";
	    	}else {
		    	if(type==0) {
		    		//直接加入群
			    	Groupmember gm=new Groupmember();
			        gm.setMemberid(userid);
			        gm.setGroupid(group.getGroupid());
			        gm.setC1(applytime);
			        int i=groupmemberService.addMember(gm);
			        if(i==1) {
						msg="添加成功";
					}else {
						msg="添加失败";
					}
		    	}else if(type==1) {
		    		//申请加入群
		    		Groupapply ga=new Groupapply();
		 	        ga.setGroupid(group.getGroupid());
		 	        ga.setApplyid(userid);
		 	        ga.setC1(applytime);
		 	        //0是未受理1是同意2是拒绝
		 	        ga.setC2(0);
		 	        int j=groupapplyService.addGroupapply(ga);
		 	        if(j==1) {
						msg="正在发送加群申请";
					}else {
						msg="发送加群申请失败";
					}
		    	}else {
		    		msg="该群不可添加";
		    	}
	    	}
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(msg);
		}
	
	@RequestMapping("/toEditGroup")
	public String toEditGroup(){
	    //System.out.println("11");
		
		return "group/teacher/editGroup";
	}
	@RequestMapping("/editGroupLoad")
	public void editGroupLoad(HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
	    //Groups group=groupsService.selectGroupsByGroupid(groupid);
		//System.out.println(group.getGroupid());
	    String jsonString = JSONArray.toJSONString(group);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	@RequestMapping("/editGroup")
	public void editGroup(@RequestParam(value="image",required=false) String image,@RequestParam(value="groupname",required=false) String groupname,@RequestParam(value="type",required=false) String type,HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		HashMap<String,Object> map = new HashMap<String,Object>();
		//int own=group.getOwner();
		System.out.println(groupname);
		group.setGroupname(groupname);
		group.setType(Integer.parseInt(type));
		if(!image.equals("init")) {
			//User currentUser = (User) request.getSession().getAttribute("currentUser");		
			String imageType = "grouplogo";//userAuatar用户公司logo
			String imagePath;
			try {
				imagePath = ImgUtils.saveImage(image, imageType);
				group.setIcon(imagePath);
			} catch (FileNotFoundException e) {
				map.put("code", "5000");//上传图片失败
				e.printStackTrace();
				//return map;			
			}
		}
		//更新目前session中用户的头像信息
		//currentUser.setIcon(imagePath);
		int cg=groupsService.updateGroups(group);
		System.out.println(group.getGroupid()+"  "+group.getOwner()+"  "+group.getGroupname());
		if(cg==1) {
			map.put("code", "0000");//请求成功
			String jsonString = JSONArray.toJSONString(map);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(jsonString);
		}else {
			map.put("code", "2000");//请求成功
			String jsonString = JSONArray.toJSONString(map);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(jsonString);
		}
	}
	
	@RequestMapping("/toSetWork")
	public String toSetWork(){
	    //System.out.println("11");
		return "group/teacher/setWork";
	}
	
	@RequestMapping("/toSetWorkList")
	public void toSetWorkList(HttpServletRequest request,HttpServletResponse res) throws IOException{
	    //System.out.println("11");
		User u=(User) request.getSession().getAttribute("currentUser");
		Groups g=(Groups) request.getSession().getAttribute("group");
		int userid=u.getUserid();
		
		Map<String, Object> map=new LinkedHashMap<String, Object>();	
		if(u.getUsertype()==0) {
			map.put("code", 6000);//请求失败，权限不够
		}else {
			User user=new User();
			user.setUserid(userid);
			//List<Paper> paperlist=paperService.selectAllPaper(user);
			List<Paper> paperlist=paperService.selectAllPaperInitial(user);
			//得到已用Paper
			List<Paper> alpaperlist=homeworkService.selectPaperFromHomework(g.getGroupid());
			for(int i=0;i<paperlist.size();i++) {
				for(int j=0;j<alpaperlist.size();j++) {
					//System.out.println(paperlist.get(i).getPaperid()+"   "+alpaperlist.get(j).getPaperid());
					if(paperlist.get(i).getPaperid().equals(alpaperlist.get(j).getPaperid())) {
						//System.out.println("paperlist.get(i).getPaperid()");
						paperlist.remove(i);
				
						//System.out.println("paperlist.get(i).getPaperid()");
					}
				}
			}
			
			map.put("code", 0000);//请求失败，权限不够
			map.put("paperlist", paperlist);
		}
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
		//return "group/teacher/indexteacher";
	}
	
	@RequestMapping("/setWork")
	public void setWork(@RequestParam(value="selected",required=false) int selected,@RequestParam(value="content",required=false) String content,@RequestParam(value="starttime",required=false) String starttime,@RequestParam(value="endtime",required=false) String endtime,HttpServletRequest req,HttpServletResponse res) throws IOException, ParseException{
		Groups g=(Groups) req.getSession().getAttribute("group");
		User u=(User) req.getSession().getAttribute("currentUser");
		DateUtils dateu=new DateUtils();
		//找到这一组的成员
		SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date publishtime=new Date();
//		System.out.println(publishtime);
		Date begintime=new Date();
		begintime=dtf.parse(starttime);
		Date stoptime=new Date();
		stoptime=dtf.parse(endtime);
//		System.out.println(begintime+"   "+stoptime);
//		Date bdt=dateu.transtime(starttime);
//		Timestamp begintime=new Timestamp(bdt.getTime());
//		Date edt=dateu.transtime(endtime);
//		Timestamp stoptime=new Timestamp(edt.getTime());
		List<Integer> useridlist=groupmemberService.selectUser(g.getGroupid());
		Paper paper=new Paper();
		paper.setPaperid(selected);
		Paper p=papermapper.selectByPrimaryKey(selected);
		p.setBegintime(begintime);
		p.setEndtime(stoptime);
		//paper.setDuration(dateu.getDatePoor(stoptime, begintime));
//		p.setType1(0);
//		p.setDoflag(0);
//		p.setPaperid(null);
		p.setPapername(p.getPaperid()+"群组作业");
		int copyp=examService.copyPaper(p);
		//int i=papermapper.insert(p);
		//int i=paperService.addPaper(p);
		//System.out.println(p.getPaperid()+" -------- ");
		Paper copyPaper=paperService.selectPaperbyId(copyp);
		List<Integer> paperidList=paperService.addPaper(copyPaper, g);

		Homework homework=new Homework();
		homework.setUserid(u.getUserid());
		homework.setPaperid(p.getPaperid());
		homework.setPublishtime(publishtime);
		homework.setGroupid(g.getGroupid());
		int j=homeworkService.addHomework(homework);
		
		//homework.setGroupid(g.getGroupid());
//		for(int i=0;i<useridlist.size();i++) {
//			homework.setUserid(useridlist.get(i));
//			homework.setPaperid(paperidList.get(i));
//			homework.setPublishtime(publishtime);
//			int j=homeworkService.addHomework(homework);
//		}

		//将布置的作业传入paper
		//更新mapper更新homework
		
		//发送作业信息到邮箱  群主收不到邮箱
		MailUrlUtils murl=new MailUrlUtils();
		String url=murl.generateActivateLink(u.getUserid(),u.getUsername());
		String subject="黑马测试，您有一份新的作业";
		String content1="点击以下链接进入作业："+url;
		List<User> gulist=groupmemberService.selectUserEntity(g.getGroupid());
		for(User gu:gulist) {
			if(gu.getUserid()!=u.getUserid()) {
				int m=mailService.sendHtmlMail(gu.getUsermail(), subject, content1);
				if(m==0) {
					return;
				}
			}
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		int cg=1;//groupsService.addGroups(group);
		if(cg==1) {
			map.put("code", "0000");//请求成功
			String jsonString = JSONArray.toJSONString(map);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(jsonString);
		}else {
			map.put("code", "2000");//请求成功
			String jsonString = JSONArray.toJSONString(map);
			res.setCharacterEncoding("UTF-8");
			res.getWriter().println(jsonString);
		}
	}
	
	
	@RequestMapping("/toCreateGroup")
	public String toCreateGroup(HttpServletRequest req){
	    //System.out.println("11");
//		User u=(User) req.getSession().getAttribute("currentUser");
//		
		return "group/teacher/createGroup";
	}
	
//	@PostMapping("/createGroup")
//    @ResponseBody
	@RequestMapping("/createGroup")
	public void insertGroups(@RequestParam(value="image",required=false) String image,@RequestParam(value="groupname",required=false) String groupname,@RequestParam(value="type",required=false) String type,HttpServletRequest req,HttpServletResponse res) throws IOException{
		//Groups g=(Groups) req.getSession().getAttribute("group");
		//User u=(User) req.getSession().getAttribute("currentUser");
		User u=(User) req.getSession().getAttribute("currentUser");
		int userid=u.getUserid();
		HashMap<String,Object> map = new HashMap<String,Object>();
		//0学生 1老师
		if(u.getUsertype()==0) {
			map.put("code", 6000);//请求失败，权限不够
		}else {
			Groups group=new Groups();
			int own=userid;
			group.setGroupname(groupname);
			group.setType(Integer.parseInt(type));
			group.setOwner(own);
			group.setLimitationnum(500);
			group.setNum(1);
			//生成码
			GroupCode code=new GroupCode();
			String gc=code.toSerialCode();
			group.setC1(gc);
			//User currentUser = (User) request.getSession().getAttribute("currentUser");	
			if(image.equals("init")) {
				String iPath = "upload\\grouplogo\\7a208724-b17d-465a-a7b0-b518f3aba1d0.jpg";
				group.setIcon(iPath);
			}else {	
				String imageType = "grouplogo";//userAuatar用户公司logo
				String imagePath;
				try {
					imagePath = ImgUtils.saveImage(image, imageType);
					group.setIcon(imagePath);
				} catch (FileNotFoundException e) {
					map.put("code", 5000);//上传图片失败
					
					e.printStackTrace();
					//return map;			
				}
			}
			//更新目前session中用户的头像信息
			//currentUser.setIcon(imagePath);
			int cg=groupsService.addGroups(group);
			if(cg==1) {
				//加入表
				Groups g=groupsService.selectGroupsByCode(gc);
				Groupmember groupmember=new Groupmember();
				groupmember.setGroupid(g.getGroupid());
				groupmember.setMemberid(userid);
				groupmember.setC2(0);
				int gi=groupmemberService.addMember(groupmember);
				map.put("code", 0000);//请求成功
				map.put("groupcode", gc);
			}else {
				map.put("code", "2000");//请求失败
			}
		
		}
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	@RequestMapping("/toDeleteGroup")
	public String toDeleteGroup(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String msg;
		User u=(User) req.getSession().getAttribute("currentUser");
		if(u.getUsertype()==0) {
			msg="没有权限";
		}else {
			Groups group=(Groups) req.getSession().getAttribute("group");
			int groupid=group.getGroupid();
		    int i=groupsService.deleteGroups(groupid);
			if(i==1) {
				msg="解散成功";
			}else {
				msg="解散失败";
			}
		}
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(msg);
		return "group/teacher/adminwork";
	}
	
	@RequestMapping("/deleteGroupUser")
	public void deleteGroupUser(@RequestParam(value="userid",required=false) int userid,HttpServletRequest req,HttpServletResponse res) throws IOException{
		//Groups group=(Groups) req.getSession().getAttribute("group");
		String msg;
		User u=(User) req.getSession().getAttribute("currentUser");
		if(u.getUsertype()==0) {
			msg="没有权限";
		}else {
		    int i=groupmemberService.deleteMember(userid);
			if(i==1) {
				msg="删除成功";
			}else {
				msg="删除失败";
			}
		}
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(msg);
	}
	
	@RequestMapping("/totransferGroup")
	public String totransferGroup() throws IOException{
		//System.out.println("111");
		return "group/teacher/transferGroup";
	}
	
	@RequestMapping("/transferGroup")
	public String transferGroup(HttpServletRequest req,@RequestParam(value="cownaccount",required=false,defaultValue="-1") String cownaccount,HttpServletResponse res) throws IOException{
		//System.out.println("ii");
		//int own=1;
	    //int cownaccount=Integer.parseInt(cownaccount);
		User u=(User) req.getSession().getAttribute("currentUser");
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		if(u.getUsertype()==0) {
			map.put("code", 6000);
		}else {
			Groups group=(Groups) req.getSession().getAttribute("group");
			User uo=new User();
			uo.setUseraccount(cownaccount);
	//		int userid=u.getUserid();
			User ownuser=userService.selectUserByAccount(uo);

				int i=groupsService.updateGroupsowner(group,ownuser.getUserid());
				group.setOwner(ownuser.getUserid());
	//			System.out.println(ownuser.getUserid());
	//		    int i=groupsService.updateGroupsowner(ownuser.getUserid());
				if(i==1) {
					group.setOwner(ownuser.getUserid());
					map.put("code", 0000);//请求失败，权限不够
				}else {
					map.put("code", 4000);//请求失败，权限不够
				}
		}
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
		return "group/teacher/adminwork";
	}
	
	@RequestMapping("/toreviewGroup")
	public String toreviewferGroup() throws IOException{
		return "group/teacher/reviewGroup";
	}
	
	@RequestMapping("/reviewGroup")
	public void reviewGroup(HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		int groupid=group.getGroupid();
		//拼接8需要  user type 从表groupapply获取申请人信息以及申请状态
	    List<Groupapply> gapplylist=groupapplyService.selectGroupapplyByGroupid(groupid);
	    List<Groups> grouplist=groupapplyService.selectGroupFromGroupapply(groupid);
	    List<User> userlist=groupapplyService.selectUserFromGroupapply(groupid);
//	    for(int i=0;i<gapplylist.size();i++) {
//	    	System.out.println(gapplylist.get(i).getApplyid()+" "+grouplist.get(i).getGroupname()+" "+userlist.get(i).getUsername());
//	    }
//	    for(Groupapply ga:gapplylist) {
//	    	//System.out.println(homework.getPublishtime());
//	    	String date= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(ga.getC1());
////	    	System.out.println(date+"date");
//	    	ga.setC1(date);
//	    }
	    
	    Map<String, List> map=new LinkedHashMap<String, List>();
	    map.put("gapplylist", gapplylist);
	    map.put("userlist", userlist);
	    map.put("grouplist", grouplist);
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/dealGroupapply")
	public void dealGroupapply(@RequestParam(value="applyid",required=false,defaultValue="-1") int applyid,@RequestParam(value="type",required=false,defaultValue="-1") int type,HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		int groupid=group.getGroupid();
	    Map<String, Integer> map=new LinkedHashMap<String, Integer>();
	    //type 1 type 2
	    Groupapply groupapply=new Groupapply();
	    groupapply.setGroupid(groupid);
	    groupapply.setApplyid(applyid);
	    groupapply.setC2(type);
	    int i=groupapplyService.updateType(groupapply);
	    if(type==1) {
	    	Groupmember gm=new Groupmember();
	 	    gm.setGroupid(group.getGroupid());
	 	    gm.setMemberid(applyid);
	 	    int j=groupmemberService.addMember(gm);
	    }
	    if(i==1) {
			map.put("code", 0000);//请求失败，权限不够
		}else {
			map.put("code", 4000);//请求失败，权限不够
		}
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/loadImg")
	public void loadImg(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String url="upload\\grouplogo\\init.jpg";
		Map<String, String> map=new LinkedHashMap<String, String>();
		map.put("icon",url);
		String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	@RequestMapping("/toDoHomework")
	public void toDoHomework(@RequestParam(value="userid",required=false,defaultValue="-1") int userid,@RequestParam(value="paperid",required=false,defaultValue="-1") int paperid,HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		int groupid=group.getGroupid();
	    Map<String, Integer> map=new LinkedHashMap<String, Integer>();
	    
	    Paper p=paperService.selectByUser(paperid, userid);
	    map.put("userid",userid);
	    map.put("userpaperid", p.getPaperid());
		map.put("code", 0000);//请求失败，权限不够
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
	
	//toPaperReport/{paperid}
	@RequestMapping("/toReviewHomework")
	public void toReviewHomework(@RequestParam(value="userid",required=false,defaultValue="-1") int userid,@RequestParam(value="paperid",required=false,defaultValue="-1") int paperid,HttpServletRequest req,HttpServletResponse res) throws IOException{
		Groups group=(Groups) req.getSession().getAttribute("group");
		int groupid=group.getGroupid();
	    Map<String, Integer> map=new LinkedHashMap<String, Integer>();
	    
	    Paper p=paperService.selectByUser(paperid, userid);
	    //map.put("userid",userid);
	    map.put("userpaperid", p.getPaperid());
		map.put("code", 0000);//请求失败，权限不够
	    String jsonString = JSONArray.toJSONString(map);
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println(jsonString);
	}
}
