create table HWUA_USER
(
  HU_USER_ID       NUMBER(10)  PRIMARY KEY,--用户id
  HU_USER_NAME     VARCHAR2(20) not null,
  HU_PASSWORD      VARCHAR2(20) not null,
  HU_SEX           CHAR(2) not null,
  HU_BIRTHDAY      DATE,
  HU_IDENTITY_CODE VARCHAR2(60),
  HU_EMAIL         VARCHAR2(80),
  HU_MOBILE        VARCHAR2(11),
  HU_ADDRESS       VARCHAR2(200) not null,
  HU_STATUS        NUMBER(6) not null
);

CREATE SEQUENCE SEQ_USER INCREMENT BY 1 START WITH 1000;

SELECT * FROM HWUA_USER;


insert into HWUA_USER (HU_USER_ID, HU_USER_NAME, HU_PASSWORD, HU_SEX, HU_BIRTHDAY, 
HU_IDENTITY_CODE, HU_EMAIL, HU_MOBILE, HU_ADDRESS, HU_STATUS)
values (SEQ_USER.NEXTVAL, 'admin', '1234', '0 ', to_date('02-07-1988', 'dd-mm-yyyy'), 
'12345678912345612X', 'sa@sina.com', '13011092066', '上海', 1);


create table HWUA_PRODUCT_CATEGORY
(
  HPC_ID        NUMBER(10) PRIMARY KEY,--商品类别id
  HPC_NAME      VARCHAR2(50) not null,
  HPC_PARENT_ID NUMBER(10) not null
);

CREATE SEQUENCE SEQ_PRODUCT_CATEGORY INCREMENT BY 100 START WITH 1;


SELECT * FROM HWUA_PRODUCT_CATEGORY;
SELECT  * FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID != HPC_PARENT_ID ;

SELECT * FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID = 2;
SELECT * FROM HWUA_PRODUCT_CATEGORY WHERE HPC_ID = 16;



insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (19, '服饰', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (21, '品牌', 21);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (22, '团购', 22);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (1, '图音', 1);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (2, '百货', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (28, 'qq', 1);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (7, '家居', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (8, '美妆', 22);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (9, '母婴', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (10, '食品', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (11, '手机数码', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (12, '家居首饰', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (13, '手表饰品', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (14, '鞋包', 21);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (15, '家电', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (16, '电脑办公', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (17, '玩具文具', 21);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (18, '汽车用品', 21);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (20, '彩票充值', 2);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (4, '音乐', 1);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (5, '运动健康', 0);
insert into HWUA_PRODUCT_CATEGORY (HPC_ID, HPC_NAME, HPC_PARENT_ID)
values (23, '易买社区', 23);

create table HWUA_NEWS
(
  HN_ID          NUMBER(10)  PRIMARY KEY,--新闻id
  HN_TITLE       VARCHAR2(80) not null,
  HN_CONTENT     VARCHAR2(1000) not null,
  HN_CREATE_TIME DATE not null
)

CREATE SEQUENCE SEQ_NEWS INCREMENT BY 1 START WITH 1;

SELECT * FROM HWUA_NEWS;

insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '会员特惠月开始', '积分大返利，机不可失失不再来!', to_date('08-03-2012 20:56:52', 
'dd-mm-yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '加入会员，赢千万大礼包', '我是会员我快乐啦啦啦啦啦', to_date('08-03-2012 20:56:52', 
'dd-mm-yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '积分兑换开始了', '积分兑换开始了积分兑换开始了积分兑换开始了', to_date('08-03-2012 
20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '配货通知', '开始配货开始配货开始配货开始配货!', to_date('08-03-2012 20:56:52', 'dd-
mm-yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '团购阿迪1折起', '团购阿迪1折起团购阿迪1折起团购阿迪1折起！', to_date('08-03-2012 
20:56:52', 'dd-mm-yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '汇源果汁大甩卖', '甩卖甩卖甩卖甩卖甩卖甩卖', to_date('08-03-2012 20:56:52', 'dd-mm-
yyyy hh24:mi:ss'));
insert into HWUA_NEWS (HN_ID, HN_TITLE, HN_CONTENT, HN_CREATE_TIME)
values (SEQ_NEWS.nextval, '苹果手机不要钱', '不要不要钱不要钱不要钱不要钱', to_date('08-03-2012 20:56:52', 
'dd-mm-yyyy hh24:mi:ss'));

create table HWUA_PRODUCT
(
  HP_ID          NUMBER(10)   PRIMARY KEY,--商品id
  HP_NAME        VARCHAR2(50) not null,
  HP_DESCRIPTION VARCHAR2(100),
  HP_PRICE       NUMBER(10,2) not null,
  HP_STOCK       NUMBER(10) not null,
  HPC_ID         NUMBER(10) ,
  HPC_CHILD_ID   NUMBER(10) ,
  HP_FILE_NAME   VARCHAR2(200) not null,
  constraint HPC_ID_FK foreign key (HPC_ID) references HWUA_PRODUCT_CATEGORY (HPC_ID),
  constraint HPC_CHILD_ID foreign key (HPC_CHILD_ID) references HWUA_PRODUCT_CATEGORY (HPC_ID)
)

CREATE SEQUENCE SEQ_PRODUCT INCREMENT BY 1 START WITH 1;
SELECT COUNT(HP_ID) FROM  HWUA_PRODUCT;
SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT;

SELECT * FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT WHERE HPC_CHILD_ID = 12) T WHERE T.R>1 AND T.R<=7;
SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT WHERE HPC_ID = 2;
SELECT * FROM HWUA_PRODUCT  WHERE HP_ID = 4;

SELECT * FROM HWUA_PRODUCT ORDER BY HP_STOCK; 
SELECT COUNT(HP_ID) FROM  HWUA_PRODUCT WHERE HP_NAME LIKE '电视';
SELECT * FROM (SELECT ROWNUM R,HWUA_PRODUCT.* FROM HWUA_PRODUCT WHERE HP_NAME LIKE '电视') T WHERE T.R>3 AND T.R<=7;
SELECT * FROM HWUA_PRODUCT WHERE HP_ID = 4;



insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '乐扣普通型保鲜盒圣诞7件套', '圣诞7件套', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '欧珀莱均衡保湿四件套', '均衡保湿四件套', 279, 50, 2, 8, 'images/product/3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '联想笔记本电脑 高速独立显存', '高速独立显存 I7处理器', 4199, 50, 2, 16, 
'images/product/4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '德菲丝巧克力', '108.00', 100, 111, 1, 4, 'images/product/1.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, 'Genius925纯银施华洛世奇水晶吊坠', '华洛世奇水晶吊坠', 69, 50, 2, 12, 
'images/product/6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '利仁2018M福满堂电饼铛 好用实惠', '福满堂电饼铛 好用实惠', 268, 50, 2, 15, 
'images/product/7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '达派高档拉杆箱20寸 经典款式', '高档拉杆箱20寸 经典款式', 198, 50, 2, 14, 
'images/product/8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '爱国者MP4 全屏触摸多格式播放 4G', '全屏触摸多格式播放 4G', 289, 50, 2, 11, 
'images/product/0.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '多美滋金装金盾3阶段幼儿配方奶粉', '金盾3阶段幼儿配方奶粉', 186, 50, 1, 10, 
'images/product/10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '德菲丝巧克力', '巧克力500g/盒', 108, 100, 1, 10, 'images/product/1.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '乐扣普通型保鲜盒圣诞7件套', '圣诞7件套', 69, 2000, 2, 7, 'images/product/2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '欧珀莱均衡保湿四件套', '均衡保湿四件套', 279, 50, 2, 8, 'images/product/3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '联想笔记本电脑 高速独立显存', '高速独立显存 I7处理器', 4199, 50, 2, 16, 
'images/product/4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '红色上衣', 199, 100, 2, 19, 'images/product/clothes2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, 'Genius925纯银施华洛世奇水晶吊坠', '华洛世奇水晶吊坠', 69, 50, 2, 12, 
'images/product/6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '利仁2018M福满堂电饼铛 好用实惠', '福满堂电饼铛 好用实惠', 268, 50, 2, 15, 
'images/product/7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '达派高档拉杆箱20寸 经典款式', '高档拉杆箱20寸 经典款式', 198, 50, 2, 14, 
'images/product/8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '爱国者MP4 全屏触摸多格式播放 4G', '全屏触摸多格式播放 4G', 289, 50, 2, 11, 
'images/product/0.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '多美滋金装金盾3阶段幼儿配方奶粉', '金盾3阶段幼儿配方奶粉', 186, 50, 1, 10, 
'images/product/10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '夹克', 99, 100, 2, 19, 'images/product/clothes3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '粉色上衣', 96, 100, 2, 19, 'images/product/clothes5.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '灰色上衣', 299, 100, 2, 19, 'images/product/clothes6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '红色上衣', 199, 100, 2, 19, 'images/product/clothes7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '银色上衣', 599, 100, 2, 19, 'images/product/clothes8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '蓝色上衣', 399, 100, 2, 19, 'images/product/clothes9.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '浅蓝色上衣', 499, 100, 2, 19, 'images/product/clothes10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '上衣', '白色上衣', 68, 100, 2, 19, 'images/product/clothes4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes1.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '灰色皮鞋', 299, 100, 21, 14, 'images/product/shoes2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '蓝色皮鞋', 299, 100, 21, 14, 'images/product/shoes3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '灰色皮鞋', 299, 100, 21, 14, 'images/product/shoes4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '棕色皮鞋', 299, 100, 21, 14, 'images/product/shoes5.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes9.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '皮鞋', '黑色皮鞋', 299, 100, 21, 14, 'images/product/shoes10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass1.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass5.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass9.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '眼镜', '太阳镜', 299, 100, 2, 12, 'images/product/sunglass10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 1299, 100, 2, 15, 'images/product/television1.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 1299, 100, 2, 15, 'images/product/television2.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/products/television3.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television4.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 3299, 100, 2, 15, 'images/product/television5.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television6.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 4299, 100, 2, 15, 'images/product/television7.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 5299, 100, 2, 15, 'images/product/television8.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 2299, 100, 2, 15, 'images/product/television9.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '电视', '彩电', 6299, 100, 2, 15, 'images/product/television10.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '卡地亚', '见证你的爱情', 22122, 100, 2, 13, 'images/product/20.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '卡地亚', '见证你的爱情', 22122, 100, 22, 22, 'images/product/20.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '双色球', '来吧', 2, 1000, 2, 20, 'images/product/21.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '变形金刚', '大黄蜂', 222, 1000, 21, 17, 'images/product/23.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, 'GPS', '导航仪', 2222, 1000, 21, 18, 'images/product/24.jpg');
insert into HWUA_PRODUCT (HP_ID, HP_NAME, HP_DESCRIPTION, HP_PRICE, HP_STOCK, HPC_ID, 
HPC_CHILD_ID, HP_FILE_NAME)
values (SEQ_PRODUCT.NEXTVAL, '123', null, 100, 111, 2, 9, 'images\product\133214492473826.jpg');


CREATE TABLE HWUA_CART 
   (ID NUMBER(10) PRIMARY KEY, --购物车id
	PID NUMBER(10), 
	QUANTITY NUMBER(10), 
	USERID NUMBER(10)
   )

CREATE SEQUENCE SEQ_HWUA_CART INCREMENT BY 1 START WITH 1;

INSERT INTO HWUA_CART VALUES(SEQ_HWUA_CART.NEXTVAL,7,1,1020)
UPDATE HWUA_CART SET QUANTITY = +2 WHERE PID = 7;
SELECT QUANTITY FROM HWUA_CART WHERE PID = 7;


CREATE TABLE HWUA_HISTORY (
	ID NUMBER(10),
	PID NUMBER(10),
	UESRID NUMBER(10),
	QUERYTIME DATE
)
CREATE SEQUENCE SEQ_HWUA_HISTORY;

INSERT INTO HWUA_HISTORY VALUES(SEQ_HWUA_HISTORY.NEXTVAL,20,20,SYSDATE);
SELECT * FROM HWUA_HISTORY WHERE UESRID = 1006 ORDER BY QUERYTIME DESC;

UPDATE HWUA_HISTORY SET QUERYTIME = SYSDATE  WHERE PID = 20 AND UESRID = 20;


create table HWUA_ORDER
(
  HO_ID           NUMBER(10) PRIMARY KEY,--订单id
  HO_USER_ID      NUMBER(10),
  HO_USER_NAME    VARCHAR2(50) not null,
  HO_USER_ADDRESS VARCHAR2(200) not null,
  HO_CREATE_TIME  DATE not null,
  HO_COST         NUMBER(10,2) not null,
  HO_STATUS       NUMBER(6) not null,
  HO_TYPE         NUMBER(6) not null,
  constraint HO_USER_ID_FK foreign key(HO_USER_ID) references HWUA_USER (HU_USER_ID)
)

CREATE SEQUENCE SEQ_ORDER INCREMENT BY 1 START WITH 1;

INSERT INTO HWUA_ORDER VALUES(SEQ_ORDER.NEXTVAL,1006,'贾乃亮','北京',SYSDATE,5000,1,1);
SELECT * FROM HWUA_ORDER WHERE HO_USER_ID = 1006;

create table HWUA_ORDER_DETAIL
(
  HOD_ID       NUMBER(10) PRIMARY KEY,--订单详情
  HO_ID        NUMBER(10),
  HP_ID        NUMBER(10),
  HOD_QUANTITY NUMBER(10) not null,
  HOD_COST     NUMBER(10,2) not null,
  constraint HOD_ID_FK foreign key (HO_ID) references HWUA_ORDER(HO_ID),
  constraint HOD_HP_ID_FK foreign key (HP_ID) references HWUA_PRODUCT(HP_ID)
)
CREATE SEQUENCE SEQ_DETAIL INCREMENT BY 1 START WITH 1;

SELECT * FROM HWUA_ORDER_DETAIL;

create table HWUA_COMMENT
(
  HC_ID          NUMBER(10) PRIMARY KEY,--评论id
	HC_title       VARCHAR2(200),
  HC_REPLY       VARCHAR2(200),
  HC_CONTENT     VARCHAR2(1000) not null,
  HC_CREATE_TIME DATE not null,
  HC_REPLY_TIME  DATE,
  HC_NICK_NAME   VARCHAR2(50) not null,
  HC_STATE       VARCHAR2(20)
)

CREATE SEQUENCE SEQ_COMMENT INCREMENT BY 1 START WITH 1;

DROP TABLE HWUA_COMMENT;
SELECT * FROM HWUA_COMMENT;

insert into HWUA_COMMENT (HC_ID,HC_REPLY, HC_CONTENT, HC_CREATE_TIME, HC_REPLY_TIME, 
HC_NICK_NAME, HC_STATE)
values (SEQ_COMMENT.NEXTVAL, '最新酷睿笔记本', 'i7超强配置，赶快下手啦!', to_date('08-03-2012 20:56:57', 'dd-mm-
yyyy hh24:mi:ss'), to_date('08-03-2012 20:56:57', 'dd-mm-yyyy hh24:mi:ss'), '天天', null);