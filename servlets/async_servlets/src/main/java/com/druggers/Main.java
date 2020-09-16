package com.druggers;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

    private static final String WEB_APP_DIR_LOCATION = "src/main/webapp/";
    private static final String WEB_APP_MOUNT_LOCATION = "/WEB-INF/classes";
    private static final String CONTEXT_PATH = "/";
    private static final String ADDITIONAL_WEBINF_CLASSES_PATH = "target/classes";

    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        StandardContext ctx = (StandardContext) tomcat.addWebapp(CONTEXT_PATH, new File(WEB_APP_DIR_LOCATION).getAbsolutePath());
        
        File additionWebInfClasses = new File(ADDITIONAL_WEBINF_CLASSES_PATH);
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, WEB_APP_MOUNT_LOCATION,
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.addUser("nizami", "nizami");
        tomcat.addRole("nizami", "user");

        tomcat.addUser("admin", "admin");
        tomcat.addRole("admin", "admin");

        tomcat.start();
        tomcat.getServer().await();
    }
}