/*
/*
1、在指定目录创建空文件dic.sqllite(目录、及文件名自己随意；建议数据库文件名以sqllite后缀结尾)
2、使用sqllite工具打开，并运行下述脚本
3、第1步创建的即为所对应的数据库文件
*/

create table t_dic(
/*字典表*/
id int primary key ,--'主键'
c_spell text not null ,--单词拼写
c_speak text,-- 发音
c_example text -- 例句
);


create table t_dic_rela(
/*字典间关系表*/
n_dic_id_main int primary key,-- 主关联词
n_dic_id_slave int-- 被关联词
);


create table t_dic_explain(
/*单词解释*/
n_dic_id int,-- 字典表主键
c_type text,-- 解释类型，eg: n、vi、vt、adj、adv
c_desc text -- 解释描述
);


