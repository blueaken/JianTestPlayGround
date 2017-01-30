http://www.cnblogs.com/zuoxiaolong/p/pattern4.html

简单工厂模式

设计原则：遵循单一职责、违背开闭原则 (出现新的类需要改写工厂类中if else分支)
常用场景：需要在一堆产品中选择其中一个产品（比如Structs2中根据地址选择不同Servlet类）
使用概率：99.99999%
复杂度：低
变化点：产品的种类
选择关键点：一种产品是否可根据某个参数决定它的种类
逆鳞：工厂类不能正常工作
相关设计模式
工厂方法模式：工厂方法模式是简单工厂模式的进一步抽象化，在这两者之间做选择，主要看将工厂进一步抽象化是否有必要，通常情况下，如果工厂的作用仅仅是用来制造产品，则没必要使用工厂方法模式。
工厂方法模式

（三）简单工厂模式详解

            上一章我们着重讨论了代理模式，以及其实现原理，相信如果你看完了整篇博文，应该就对代理模式很熟悉了。

            本章我们讨论简单工厂模式，LZ当初不小心夸下海口说不和网络上传播的教学式模式讲解雷同，所以现在感觉写一篇博文压力颇大。

            如何来介绍简单工厂呢，LZ着实费了不少心思，这个模式本身不复杂，但其实越是不复杂的模式越难写出特点，因为它太简单。

            为了便于各位看后面例子的时候容易理解，LZ这里先给出引自其它地方的简单工厂模式的定义。

            定义：从设计模式的类型上来说，简单工厂模式是属于创建型模式，又叫做静态工厂方法（Static Factory Method）模式，但不属于23种
            GOF设计模式之一。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式，可
            以理解为是不同工厂模式的一个特殊实现。

            定义中最重要的一句话就是，由一个工厂对象决定创建出哪一种产品类的实例，这个LZ在下面会专门举一个现实应用中的例子去展现。



            上面便是标准的简单工厂模式的类图和代码给出，是为了一些新手先熟悉一下这个设计模式的大体框架，方便我们下面使用实际的例子去阐述
            的时候更加容易理解。

            下面LZ就找一个各位基本上都使用过或者将来要使用的一个例子来说明简单工厂模式，我们去模拟一个简单的struts2的功能。

            LZ会自己制作一个简单的WEB项目来做例子，其中会忽略掉很多细节，目的是为了突出我们的简单工厂模式。

            众所周知，我们平时开发web项目大部分是以spring作为平台，来集成各个组件，比如集成struts2来完成业务层与表现层的逻辑，集成
            hibernate或者ibatis来完成持久层的逻辑。

            struts2在这个过程当中提供了分离数据持久层，业务逻辑层以及表现层的责任，有了Struts2，我们不再需要servlet，而是可以将一个
            普通的Action类作为处理业务逻辑的单元，然后将表现层交给特定的视图去处理，比如JSP,template等等。

            我们来尝试着写一个非常非常简单的web项目，来看看在最原始的时候，也就是没有spring，struts2等等这些个开源框架的时候，我们都是
            怎么过的。

            由于LZ会省略WEB架构过程当中的很多细节，所以最好是各位亲手做过一些项目，相对而言看起来会更有体会一些，不过LZ相信既然有兴趣来
            看设计模式，应该都基本上有过这种锻炼。

            下面LZ把我们一个简单的WEB项目中需要的类都列出来，并加上简单的注释。

复制代码
import javax.servlet.http.HttpServlet;

//假设这是一个小型的WEB项目，我们通常里面会有这些类

//这个类在代理模式出现过，是我们的数据源连接池，用来生产数据库连接。
class DataSource{}

//我们一般会有这样一个数据访问的基类，这个类要依赖于数据源
class BaseDao{}

//一般会有一系列这样的DAO去继承BaseDao，这一系列的DAO类便是数据持久层
class UserDao extends BaseDao{}
class PersonDao extends BaseDao{}
class EmployeeDao extends BaseDao{}

//我们还会有一系列这样的servlet，他们通常依赖于各个Dao类，这一系列servlet便是我们的业务层
class LoginServlet extends HttpServlet{}
class LoginOutServlet extends HttpServlet{}
class RegisterServlet extends HttpServlet{}

//我们通常还会有HTML页面或者JSP页面，但是这个本次不在考虑范围内，这便是表示层。

复制代码
             以上是我们小型WEB项目大体的结构，可以看到LZ写了三个Servlet，没有写具体的实现到底如何，但是不难猜测，三个servlet的功能分别是进行登录，注销，以及注册新用户的功能。我们的servlet一般都是继承自HttpServlet，因为我们在web.xml配置servlet时，所写入的Class需要实现servlet接口，而我们通常采用的传输协议都是HTTP，所以HttpServlet就是我们最好的选择了，它帮我们完成了基本的实现。

            但是这样我们有很多限制，比如我们一个servlet一般只能负责一个单一的业务逻辑，因为我们所有的业务逻辑通常情况下都集中在doPost这样一个方法当中，可以想象下随着业务的增加，我们的servlet数量会高速增加，这样不仅项目的类会继续增加，最最恶心的是，我们每添加一个servlet就要在web.xml里面写一个servlet配置。

            但是如果我们让一个Servlet负责多种业务逻辑的话，那我们需要在doPost方法中加入很多if判断，去判断当前的操作。

            比如我们将上述三个servlet合一的话，你会在doPost出现以下代码。

复制代码
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //我们加入一个操作的参数，来让servlet做出不同的业务处理
        String operation = req.getParameter("operation");
        if (operation.equals("login")) {
            System.out.println("login");
        }else if (operation.equals("register")) {
            System.out.println("register");
        }else if (operation.equals("loginout")) {
            System.out.println("loginout");
        }else {
            throw new RuntimeException("invalid operation");
        }
    }
复制代码
           这实在是非常烂的代码，因为每次你新加一个操作，都要修改doPost这个方法，而且多个业务逻辑都集中在这一个方法当中，会让代码很难维护与扩展，最容易想到的就是下列做法。（小提示：如果你的项目中出现了这种代码结构，请务必想办法去掉它，你完全可以尽量忘掉Java里还有elseif和swich）

复制代码
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //我们加入一个操作的参数，来让servlet做出不同的业务处理
        String operation = req.getParameter("operation");
        if (operation.equals("login")) {
            login();
        }else if (operation.equals("register")) {
            register();
        }else if (operation.equals("loginout")) {
            loginout();
        }else {
            throw new RuntimeException("invalid operation");
        }
    }

    private void login(){
        System.out.println("login");
    }

    private void register(){
        System.out.println("register");
    }

    private void loginout(){
        System.out.println("loginout");
    }
复制代码
           这样会比第一种方式好一点，一个方法太长，实在不是什么好征兆，等到你需要修改这部分业务逻辑的时候，你就会后悔你当初的写法了，如果这段代码不是亲手写的，那请你放心的在心中吐糟吧，因为这实在不是一个合格的程序员应该写出的程序。

           虽然我们已经将各个单一的业务逻辑拆分成方法，但这依然是违背单一原则这个小萝莉的，因为我们的servlet应该只是处理业务逻辑，而不应该还要负责与业务逻辑不相关的处理方法定位这样的责任，这个责任应该交给请求方，原本在三个servlet分别处理登陆，注销和注册的时候，其实就是这样的，作为请求方，只要是请求LoginServlet，就说明请求的人是要登陆，处理这个请求的servlet不需要再出现有关判断请求操作的代码。

           所以我们需要想办法把判断的业务逻辑交给请求方去处理，回想下struts2的做法，我们可以简单模拟下struts2的做法。相信不少同学应该都用过struts2，那么你肯定对以下配置很熟悉。

复制代码
 <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
复制代码
              这是struts2最核心的filter，它的任务就是分派各个请求，根据请求的URL地址，去找到对应的处理该请求的Action。

              我们来模拟一个分配请求的过滤器，它的任务就是根据用户的请求去产生响应的servlet处理请求，而这些servlet其实就是上面的例子当中的productA和productB这类的角色，也就是具体的产品，而它们实现的接口正是Servlet这个抽象的产品接口。

              我们用这个过滤器来消除servlet在web.xml的配置，帮我们加快开发的速度，我们写出如下filter。

复制代码
package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.web.factory.ServletFactory;
//用来分派请求的filter
public class DispatcherFilter implements Filter{

    private static final String URL_SEPARATOR = "/";

    private static final String SERVLET_PREFIX = "servlet/";

    private String servletName;

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain) throws IOException, ServletException {
        parseRequestURI((HttpServletRequest) servletRequest);
        //这里为了体现我们本节的重点，我们采用一个工厂来帮我们制造Action
        if (servletName != null) {
            //这里使用的正是简单工厂模式，创造出一个servlet，然后我们将请求转交给servlet处理
            Servlet servlet = ServletFactory.createServlet(servletName);
            servlet.service(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    //负责解析请求的URI，我们约定请求的格式必须是/contextPath/servlet/servletName
    //不要怀疑约定的好处，因为LZ一直坚信一句话，约定优于配置
    private void parseRequestURI(HttpServletRequest httpServletRequest){
        String validURI = httpServletRequest.getRequestURI().replaceFirst(httpServletRequest.getContextPath() + URL_SEPARATOR, "");
        if (validURI.startsWith(SERVLET_PREFIX)) {
            servletName = validURI.split(URL_SEPARATOR)[1];
        }
    }

}
复制代码
              这个filter需要在web.xml中加入以下配置，这个不多做介绍，直接贴上来。

复制代码
<filter>
      <filter-name>dispatcherFilter</filter-name>
      <filter-class>com.web.filter.DispatcherFilter</filter-class>
  </filter>
  <filter-mapping>
      <filter-name>dispatcherFilter</filter-name>
      <url-pattern>/servlet/*</url-pattern>
  </filter-mapping>
复制代码
                LZ在filter中稍微加入了一些注释，由于本章的重点是简单工厂模式，所以我们这里突出我们本章的主角，使用简单工厂来创造servlet去处理客户的请求，当然如果你是一个JAVA造诣比较深的程序猿，出于好奇进来一观，或许会对这种简单工厂模式的处理方式不屑一顾，不过我们不能偏离主题，我们的目的不是模拟一个struts2，而是介绍简单工厂。

                下面给出我们的主角，我们的servlet工厂，它就相当于上面的Creator。

复制代码
package com.web.factory;

import javax.servlet.Servlet;

import com.web.exception.ServletException;
import com.web.servlet.LoginServlet;
import com.web.servlet.LoginoutServlet;
import com.web.servlet.RegisterServlet;

public class ServletFactory {

    private ServletFactory(){}
    //一个servlet工厂，专门用来生产各个servlet，而我们生产的依据就是传入的servletName，
    //这个serlvetName由我们在filter截获，传给servlet工厂。
    public static Servlet createServlet(String servletName){
        if (servletName.equals("login")) {
            return new LoginServlet();
        }else if (servletName.equals("register")) {
            return new RegisterServlet();
        }else if (servletName.equals("loginout")) {
            return new LoginoutServlet();
        }else {
            throw new ServletException("unknown servlet");
        }
    }
}
复制代码
                看到这里，是不是有点感觉了呢，我们一步一步去消除servlet的XML配置的过程，其实就是在慢慢的写出一个简单工厂模式，只是在这之中，抽象的产品接口是现成的，也就是Servlet接口。

                虽说这些个elseif并不是好代码的征兆，不过这个简单工厂最起码帮我们解决了恶心的xml配置，说起来也算功不可没。

                现在我们可以请求/contextPath/servlet/login来访问LoginServlet，而不再需要添加web.xml的配置，虽说这么做，我们对修改是开放的，因为每增加一个servlet，我们都需要修改工厂类，去添加一个if判断，但是LZ个人还是觉得我宁可写if，也不想去copy那个当初让我痛不欲生的xml标签，虽说我刚才还说让你忘掉elseif，我说过吗？好吧。。我说过，但是这只是我们暂时的做法，我们可以有很多种做法去消除掉这些elseif。

                简单工厂是设计模式当中相对比较简单的模式，它甚至都没资格进入GOF的二十三种设计模式，所以可见它多么卑微了，但就是这么卑微的一个设计模式，也能真正的帮我们解决实际当中的问题，虽说这种解决一般只能针对规模较小的项目。

                写到这里，简单工厂模式当中出现的角色，已经很清晰了。我们上述简单工厂当中设计到的类就是Servlet接口，ServletFactory以及各种具体的LoginServlet，RegisterServlet等等。

               总结起来就是一个工厂类，一个产品接口（其实也可以是一个抽象类，甚至一个普通的父类，但通常我们觉得接口是最稳定的，所以基本不需要考虑普通父类的情况），和一群实现了产品接口的具体产品，而这个工厂类，根据传入的参数去创造一个具体的实现类，并向上转型为接口作为结果返回。

               我们在这里将上述穿插的简单工厂模式抽离出来，注释中有LZ个人的见解，帮助各位理解。

复制代码
//相当于简单工厂模式中的产品接口
interface Servlet{}
//相当于简单工厂模式中的抽象父类产品。
//注意，简单工厂在网络上的资料大部分为了简单容易理解都是只规划了一个产品接口，但这不代表就只能有一个，设计模式的使用要灵活多变。
class HttpServlet implements Servlet{}
//具体的产品
class LoginServlet extends HttpServlet{}
class RegisterServlet extends HttpServlet{}
class LoginoutServlet extends HttpServlet{}
//产品工厂
public class ServletFactory {

    private ServletFactory(){}
    //典型的创造产品的方法，一般是静态的，因为工厂不需要有状态。
    public static Servlet createServlet(String servletName){
        if (servletName.equals("login")) {
            return new LoginServlet();
        }else if (servletName.equals("register")) {
            return new RegisterServlet();
        }else if (servletName.equals("loginout")) {
            return new LoginoutServlet();
        }else {
            throw new RuntimeException();
        }
    }
}
复制代码
               上面LZ已经将刚才的过程给抽离出来，各位可以对比下标准的简单工厂代码，就会发现它们其实是一模一样的设计方式。

               为了更加方便各位的对比，LZ这里给出上面JAVA代码的类图。


               上面便是我们例子当中有关Servlet创建时，出现的简单工厂模式类图，各位可以和第一次的标准类图对比一下，它们的设计都是一样的。

               其实我们针对创建Servlet实例这一部分逻辑的控制依旧有很多很多的优化余地，但是限于本章介绍的内容，所以我们就适可而止。

               LZ觉得想简单工厂这种没有什么技术上的难度，纯粹是依照一些业务场景而出现的设计模式，LZ就必须要创造出一个比较真实的业务场景或者现实中的例子，才能更好的诠释。所以本次LZ先拿出了我们经常做的WEB项目，以后LZ也会尽量举一些实际应用的例子。

              好了，本期的简单工厂模式就到这里吧，感谢各位的收看！

