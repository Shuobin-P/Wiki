package com.google.wiki.controller;

import com.google.wiki.domain.Ebook;
import com.google.wiki.req.EbookReq;
import com.google.wiki.resp.CommonResp;
import com.google.wiki.resp.EbookResp;
import com.google.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    /**
     * 查询所有电子书的方法
     */
    @GetMapping("/getAllEbook")
    public CommonResp<List<Ebook>> selectAllEbook() {
        List<Ebook> list = ebookService.getAll();
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        resp.setMessage("查询成功");
        resp.setContent(list);
        return resp;
    }

    /**
     * 带查询条件的查询（因为不能确定具体多少个参数，所以封装请求参数）
     * 封装请求参数的模拟方法
     */
    @GetMapping("/getEbook")
    public CommonResp<List<EbookResp>> selectEbook(EbookReq ebookReq) {
        List<EbookResp> list = ebookService.getEbook(ebookReq);
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        resp.setMessage("查询成功");
        resp.setContent(list);
        return resp;
    }
}
