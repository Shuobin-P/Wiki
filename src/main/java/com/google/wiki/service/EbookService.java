package com.google.wiki.service;

import com.google.wiki.domain.Ebook;
import com.google.wiki.domain.EbookExample;
import com.google.wiki.mapper.EbookMapper;
import com.google.wiki.req.EbookReq;
import com.google.wiki.resp.EbookResp;
import com.google.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> getAll() {
        return ebookMapper.selectByExample(null);
    }

    public List<EbookResp> getEbook(EbookReq ebookReq) {
        //这个EbookExample是干什么的
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(ebookReq.getName())) {
            criteria.andNameLike("%" + ebookReq.getName() + "%");
        }
        criteria.andNameLike("%" + ebookReq.getName() + "%");

        // 这里查出来的是Ebook，里面字段和表字段是一样的，但是我们返回出去的是响应封装类，因此要转化一下
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        // 把List<Ebook>转化成List<EbookResp>
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }
}