package com.study.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.notice.Notice;
import com.study.springboot.notice.NoticeDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoticeController {
	
	private NoticeDao noticeDao;
	
	@Autowired
	public NoticeController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@RequestMapping("/notice")
	public String showNoticeList(Model model) {
		List<Notice> noticeAll = noticeDao.selectAll();
		model.addAttribute("noticeAll", noticeAll);
		return "notice/noticeAll";
	}
	
	@RequestMapping("/notice/{id}")
	public String showNotice(@PathVariable long id, Model model) {
		Notice noticeOne = noticeDao.SelectById(id);
		model.addAttribute("notice", noticeOne);
		return "notice/noticeOne";
	}
	
	@GetMapping("/notice/write")
	public String WriteForm() {
		return "notice/writeForm";
	}
	
	@PostMapping("/notice/write")
	public String writeNotice(Notice notice) {
		noticeDao.insert(notice);
		return "redirect:/notice";
	}
	
	@RequestMapping("/notice/delete/{id}")
	public String deleteNotice(@PathVariable long id) {
		noticeDao.delete(id);
		return "notice/deleteConfirm";
	}
	
	@GetMapping("/notice/update/{id}")
	public String updateForm(@PathVariable long id, Model model){
		Notice noticeOne = noticeDao.SelectById(id);
		model.addAttribute("notice", noticeOne);
		return "notice/updateForm";
	}
	
	@PostMapping("/notice/update/{id}")
	public String updateNotice(@PathVariable long id,@ModelAttribute Notice notice) {
		notice.setId(id);
		noticeDao.update(notice);
		return "redirect:/notice";
	}
	
}