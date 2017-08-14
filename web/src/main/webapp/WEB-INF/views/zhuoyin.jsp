<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2017/8/13
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <title>卓音工作室主页</title>
    <link rel="stylesheet" type="text/css" href="../css/zhuye1.css">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/zhuye1.js"></script>
</head>
<body>
<div class="page">
    <div class="load">
        <img src="../img/load.gif">
    </div>
    <nav class="nav"><!-- 导航 -->
        <img src="../img/111.jpg" class="sign">
        <h1 class="title">卓音工作室</h1>
        <ul class="menu">
            <li class="level1">
                <a href="javascript:;">工作室介绍</a>
            </li>
            <li class="level1">
                <a href="javascript:;">致力于技术</a>
            </li>
            <li class="level1">
                <a href="javascript:;">加入我们</a>
            </li>
            <li class="level1">
                <a href="javascript:;">团队文化</a>
            </li>
        </ul>
        <div class="level2">
            <ul class="level3" id="ul1">
                <li><a href="">环境</a></li>
                <li><a href="">荣誉</a></li>
                <li><a href="">关于我们</a></li>
            </ul>
            <ul class="level3">
                <li><a href="">前端</a></li>
                <li><a href="">后端</a></li>
                <li><a href="">产品部</a></li>
            </ul>
            <ul class="level3">
                <li><a href="">人事制度</a></li>
                <li><a href="">招聘指南</a></li>
                <li><a href="">报名表</a></li>
            </ul>
            <ul class="level3">
                <li><a href="">团队精神</a></li>
                <li><a href="">平时交流</a></li>
                <li><a href="">文化衫</a></li>
            </ul>
        </div>
        <div class="search">
            <label>搜索　</label>
            <input type="text" name="">
        </div>
    </nav>
    <div id="main"><!-- 轮播 -->
        <div id="carousel">
            <img src="../img/99999.jpg">
            <img src="../img/88888.jpg">
            <img src="../img/77777.jpg">
            <img src="../img/66666.jpg">
        </div>
        <div id="buttons">
            <span class="on"></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <a href="javascript:;" class="arrow" id="next">&gt;</a>
        <a href="javascript:;" class="arrow" id="prev">&lt;</a>
    </div>
    <div class="center">
        <div class="center-left">
            <h1 class="center-left-title-1">卓音新闻</h1>
            <img src="../img/yitihua04.gif" class="center-left-picture">
            <p class="center-left-title-2">我们只是分享了几个故事，对你来说也许是平凡小事。</p>
            <p class="article">说出的字一秒就变了历史，我只想紧抓着不让它流逝。说出的字一秒就变了历史，我只想紧抓着不让它流逝。说出的字一秒就变了历史，我只想紧抓着不让它流逝。</p>
        </div>
        <div class="center-c">
            <a href="http://www.nenu.edu.cn/" class="more">更多></a>
            <div class="center-c-date">
                <div class="date-left">10</div>
                <span class="date-on">08月</span>
                <span class="date-low">2017</span>
            </div>
            <a href="http://www.nenu.edu.cn/72/42/c139a29250/page.htm" class="center-c-link-">卓音工作室迎来10周年庆大家非常高兴啦啦啦啦啦啦啦啦啦啦</a>
            <div class="center-c-date">
                <div class="date-left">10</div>
                <span class="date-on">08月</span>
                <span class="date-low">2017</span>
            </div>
            <a href="http://www.nenu.edu.cn/72/42/c139a29250/page.htm" class="center-c-link-">卓音工作室迎来10周年庆大家非常高兴啦啦啦啦啦啦啦啦啦啦</a>
            <div class="center-c-date">
                <div class="date-left">07</div>
                <span class="date-on">06月</span>
                <span class="date-low">2017</span>
            </div>
            <a href="http://www.nenu.edu.cn/72/42/c139a29250/page.htm" class="center-c-link-">卓音工作室迎来10周年庆大家非常高兴啦啦啦啦啦啦啦啦啦啦</a>
            <div class="center-c-date">
                <div class="date-left">07</div>
                <span class="date-on">06月</span>
                <span class="date-low">2017</span>
            </div>
            <a href="http://www.nenu.edu.cn/72/42/c139a29250/page.htm" class="center-c-link-">卓音工作室迎来10周年庆大家非常高兴啦啦啦啦啦啦啦啦啦啦</a>
            <div class="center-c-date">
                <div class="date-left">07</div>
                <span class="date-on">06月</span>
                <span class="date-low">2017</span>
            </div>
            <a href="http://www.nenu.edu.cn/72/42/c139a29250/page.htm" class="center-c-link-">卓音工作室迎来10周年庆大家非常高兴啦啦啦啦啦啦啦啦啦啦</a>
        </div>
        <div class="center-c">
            <h1 class="center-c-title-3">通知公告</h1>
            <a href="" class="link01">招聘</a>
            <a href="" class="link01">招标</a>
            <a href="" class="more-">更多></a>
            <c:forEach items="${newsList}" var="news" varStatus="status">
            <p class="link02">
                <a href="" class="link03">${news.title}</a>
                <span class="date-">[${news.date}]</span>
            </p>
            </c:forEach>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
            <%--<p class="link02">--%>
                <%--<a href="" class="link03">前端招聘你来不来来不来来不来</a>--%>
                <%--<span class="date-">[06.07]</span>--%>
            <%--</p>--%>
        </div>
    </div>
    <div class="middle">
        <p class="middle-tip"><本部和净月图片展示></p>
        <div id="submain">
            <div id="sub-carousel">
                <img src="../img/3.jpg">
                <img src="../img/4.jpg">
            </div>
        </div>
        <a href="javascript:;" class="sub-arrow" id="sub-next">净月</a>
        <a href="javascript:;" class="sub-arrow" id="sub-prev">本部</a>
        <div class="middle-down">
            <ul>
                <li class="cadre">
                    <div class="middle-left">
                        <p>卓音工作室本部</p>
                    </div>
                    <div class="middle-right">
                        <table>
                            <tr>
                                <td>总人数</td>
                                <td>前端人数</td>
                                <td>后端人数</td>
                                <td>产品部人数</td>
                                <td>成立周年</td>
                            </tr>
                            <tr class="num">
                                <td><span>44</span></td>
                                <td><span>33</span></td>
                                <td><span>14</span></td>
                                <td><span>4</span></td>
                                <td><span>14</span></td>
                            </tr>
                        </table>
                    </div>
                </li>
                <li class="branch">
                    <div class="middle-left">
                        <p>卓音工作室净月</p>
                    </div>
                    <div class="middle-right">
                        <table>
                            <tr>
                                <td>总人数</td>
                                <td>前端人数</td>
                                <td>后端人数</td>
                                <td>产品部人数</td>
                                <td>成立周年</td>
                            </tr>
                            <tr class="num">
                                <td><span>144</span></td>
                                <td><span>133</span></td>
                                <td><span>10</span></td>
                                <td><span>1</span></td>
                                <td><span>10</span></td>
                            </tr>
                        </table>
                    </div>
                </li>
            </ul>
        </div>
        <div class="part-content">
            <div class="wrapper">
                <div class="part1">
                    <img src="../img/part4.gif" class ="picture1">
                    <a href="javascript:;" class="color1">
                        <h1><卓音工作室概况></h1>
                        <p>卓音工作室环境好，反正各种好巴拉巴拉巴拉巴拉巴拉巴拉</p>
                    </a>
                </div>
                <div class="part2">
                    <img src="../img/part4.gif" class="picture2">
                    <a href="javascript:;" class="color2">
                        <h1><技术部></h1>
                        <p>卓音是最厉害的哈哈哈巴拉巴拉巴拉巴拉巴拉巴拉</p>
                    </a>
                </div>
                <div class="part3">
                    <img src="../img/part4.gif" class="picture3">
                    <a href="javascript:;" class="color3">
                        <h1><设计部></h1>
                        <p>卓音设计部也是很厉害的哈哈哈巴拉巴拉巴拉巴拉巴拉巴拉</p>
                    </a>
                </div>
                <div class="part4">
                    <img src="../img/part4.gif" class="picture4">
                    <a href="javascript:;" class="color4">
                        <h1><产品部></h1>
                        <p>卓音产品部也是很厉害的哈哈哈巴拉巴拉巴拉巴拉巴拉巴拉</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="bottom">
        <p class="bottom-">来卓音，和有意思的人，发现更精彩的自己</p>
        <hr>
        <img src="../img/2wm1.jpg" alt="二维码" class="bottom-img">
        <img src="../img/2wm2.jpg" alt="二维码">
        <p class="bottom-text">版权所有©东北师范大学 吉ICP备05004942</p><br>
        <p>维护：信息化管理与规划办公室</p><br>
        <p>本部邮箱：zhuoyin@163.com</p><br>
        <p>净月邮箱：zhuyinjingyue@163.com</p><br>
        <p>本部地址：吉林省长春市南关区人民大街5268号（130024）</p><br>
        <p class="bottom_">净月地址：吉林省长春市净月旅游开发区净月大街2555号（130024）</p>
    </div>
</div>
</body>
</html>
