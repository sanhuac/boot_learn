package com.huc.boot.service;

import com.huc.boot.bean.DriveTopicEntry;
import com.huc.boot.bean.DriveTopicOne;
import com.huc.boot.bean.DriveTopicType;
import com.huc.boot.dao.DriveTopicEntryMapper;
import com.huc.boot.dao.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/8/13 16:23
 * @Description:
 */
@Service
public class TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private DriveTopicEntryMapper driveTopicEntryDao;

    public List<DriveTopicOne> list(){
        //查询题库
        List<DriveTopicOne> list = titleMapper.selectAll(1);
        if(list.size()>0){
        for(int i=0;i<list.size();i++){
            //题目所对应得专题
            List<DriveTopicEntry> topicEntries = driveTopicEntryDao.entryTypeBytitleId(list.get(i).getId());
            String specialTitle = "";//专题所属类型
            String chapter_type = "";//章节类型
            String wrong_type = "";//易错题,争议题
            for(int j=0;j<topicEntries.size();j++){
                String s = driveTopicEntryDao.typeNameBytypeIdandtype(topicEntries.get(j).getType(), topicEntries.get(j).getType_id());
                if(topicEntries.get(j).getType()==1){
                    chapter_type=chapter_type+=","+s;

                }
                if(topicEntries.get(j).getType()==2){
                    wrong_type=wrong_type+=s;
                }
                if(topicEntries.get(j).getType()==3){
                    wrong_type=wrong_type+=","+s;
                }
                if(topicEntries.get(j).getType()==4){
                    specialTitle=specialTitle+=","+s;
                }

            }
            list.get(i).setSpecialTitle(specialTitle);
            list.get(i).setChapter_type(chapter_type);
            list.get(i).setWrong_type(wrong_type);
            //题目所对应的章节[1:第一章 2:第二章 3:第三章 4:第四章]

            //题目所对应的易错题[0:都不是 1:易错题 2:争议题]
        }
        }
        return list;
    }

    /**
     *@描述 查询所有题目类型
     *@参数
     *@返回值  
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    public List<String> topicTypes(Integer type){
        List<DriveTopicType> driveTopicTypes = driveTopicEntryDao.topicTypes(type);
        List<String> specail_type = new ArrayList<String>();
        for(int i=0;i<driveTopicTypes.size();i++){
            specail_type.add(driveTopicTypes.get(i).getName());
        }

        return specail_type;
    }

    /**
     *@描述 查询所有题目类型和题目的映射
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/8/14
     *@修改人和其它信息
     */
    public List<DriveTopicEntry> entryTypes(){
        List<DriveTopicEntry> driveTopicEntries = driveTopicEntryDao.entryTypes();
        return driveTopicEntries;
    }
}
