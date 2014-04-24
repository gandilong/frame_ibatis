<#macro jing>#</#macro>
<#macro dao>$</#macro>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${namespace}">
       
       <select id="query" parameterType="ActionValues" resultType="ResultValues">
            select * from ${tableName}
            <trim prefix="where" prefixOverrides="and|or">
                <#list fieldNames as fieldName>
                    <if test="null!=${fieldName}">
                        <@addUnderLine>${fieldName}</@addUnderLine><#if fieldName?ends_with("name") || fieldName?ends_with('Name') || fieldName?ends_with('title')> like '%<@dao/>{${fieldName}}%'</#if><#if !(fieldName?ends_with("name")||fieldName?ends_with("Name") || fieldName?ends_with('title') )>=<@jing/>{${fieldName}}</#if> 
                    </if>
                </#list>
            </trim>
       </select>
       
       <insert id="toInsert" parameterType="ActionValues">
           insert into ${tableName}(
           <#list columnNames as columnName>
               ${columnName}<#if columnName_index &lt; columnNames?size-1>,</#if>
           </#list>
           ) values(
             <#list fieldNames as fieldName>
                <@jing/>{${fieldName}}<#if fieldName_index &lt; fieldNames?size-1>,</#if>
             </#list>
           )
       </insert>
       
       <delete id="toDelete" parameterType="long">
          <if test="null!=id">
               delete from ${tableName} where ${id}=<@jing/>{id}
          </if>
       </delete>
       
       <delete id="toDeletes" parameterType="ActionValues">
          <if test="null!=ids">
            delete from ${tableName} where ${id} in
            <foreach item="id" index="index" collection="ids" open="(" separator="," close=")">  
               <@jing/>{id}  
            </foreach>  
          </if>
      </delete>
      
       <update id="toUpdate" parameterType="ActionValues">
          <if test="null!=id">
               update ${tableName}
               <trim prefix="SET" suffixOverrides=",">
                   <#list fieldNamesNoID as fieldName>
                       <if test="null!=${fieldName}">
                           <@addUnderLine>${fieldName}</@addUnderLine>=<@jing/>{${fieldName}}<#if fieldName_index &lt; fieldNames?size-2>,</#if>
                       </if>
                   </#list>
               </trim>
               where ${id}=<@jing/>{id}
          </if>
       </update>
       
</mapper> 
