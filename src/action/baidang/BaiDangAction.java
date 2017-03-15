package action.baidang;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.BaiDangForm;
import model.bean.User;
import model.bo.BaiDangBO;
import model.bo.BinhLuanBO;
import model.bo.ThichBO;
/**
 * BaiDangAction
 *
 * Version 1.0
 *
 * Date: 14-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 14-3-2017         DonNA            Create
 */
public class BaiDangAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaiDangForm thisForm = (BaiDangForm) form;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userActivity");
		//thich > set and get yeuThich
		if(user!=null){
			boolean like=ThichBO.checkThich(thisForm.getMaBaiDang(),user.getUserName());
			if (like) {
				ThichBO.setThich(like,thisForm.getMaBaiDang(),user.getUserName(),thisForm.isYeuThich());
				thisForm.setYeuThich(like);
			}else{
				ThichBO.setThich(like,thisForm.getMaBaiDang(),user.getUserName(),thisForm.isYeuThich());
			}
		}
		if (StringProcess.equals(thisForm.getSubmit(), "binhLuan")){
			ActionErrors errors = new ActionErrors();
			errors = thisForm.validateBaiDang(mapping, request);
			if (!errors.isEmpty()) {
				/*saveErrors(request, errors);
				thisForm.setListDanhMuc(DanhMucBO.getListDanhMuc());
				thisForm.setListTinhThanh(TinhThanhBO.getListTinhThanh());
				thisForm.setListDichVu(DichVuBO.getListDichVu());
				return mapping.getInputForward();*/
			}
			else if(StringProcess.equals(thisForm.getSubmit(), "binhLuan")){
				thisForm.setBl_userName((user.getUserName()));
				BinhLuanBO.insertBinhLuan(thisForm.getBinhLuan());
				thisForm.setBaiDang(BaiDangBO.infoBaiDang(thisForm.getMaBaiDang()));
				return mapping.getInputForward();
			}
		}
		
		thisForm.setBaiDang(BaiDangBO.infoBaiDang(thisForm.getMaBaiDang()));
		return mapping.getInputForward();
	}

}
