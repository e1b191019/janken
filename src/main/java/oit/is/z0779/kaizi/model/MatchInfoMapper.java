package oit.is.z0779.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper{

@Select("SELECT * FROM matchinfo")
  ArrayList<MatchInfo> selectAllMatchInfo();

@Select("SELECT * FROM matchinfo WHERE isActive IS true")
  ArrayList<MatchInfo> selectAllMatchInfoTrue();

@Insert("INSERT INTO matchinfo (user1,user2,user1Hand,isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchinfo);

}
