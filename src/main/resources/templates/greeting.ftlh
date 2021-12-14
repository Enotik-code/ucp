<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <div class="DemoMRP System">
        <h1 class="display-4 mb-5">Транспортная логистика!</h1>
        <h3 class="font-weight-light">Мы можем предложить вам:</h3>
        <hr class="my-4">
        <h4 class="font-weight-light"> - поиск грузоперевозчика</h4>
        <h4 class="font-weight-light"> - контроль потребностей в перевозке</h4>
        <h4 class="font-weight-light"> - личный кабинет</h4>
        <h4 class="font-weight-light"> - учет транспорта</h4>

        <#if !user??>
            <p class="lead mt-3">
                <a class="btn btn-secondary btn-lg" href="/login" role="button">Попробовать</a>
            </p>
        </#if>

    </div>
</@c.page>