<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light w-15 p-3 h5">
    <a class="navbar-brand" href="/">PISL</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Домашняя страница</a>
            </li>
            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/cargo">Груз</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/deliveryList">Доставка</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/company">Компания</a>
                </li>
            </#if>
        </ul>
        <#if user??>
                <a class="nav-link mr-3 text-secondary" href="/personalPage"> Личный кабинет </a>
        </#if>
        <div class="navbar-text mr-3">${name}</div>

        <#if user??>
            <@l.logout />
        <#else>
            <form action="/login"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-secondary btn-lg" type="submit">Войти</button>
            </form>
        </#if>


    </div>
</nav>