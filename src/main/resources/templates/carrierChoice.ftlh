<#import "parts/common.ftlh" as c>

<@c.page>


    <#assign counter = 0>
    <#list companies as company>
        <div class="card w-100" >
            <div class="card-body ">
                <div class="row" id="myDIV">
                    <div class="col-sm-4">
                        <h3 class="font-weight-normal card-title " id="list-item-${company.id}">Компания-грузоперевозчик: ${company.name} </h3>
                        <h4 class="font-weight-normal">Стоимость перевозки: ${deliveryCosts[counter]} </h4>
                        <h4 class="font-weight-normal">Среднее время перевозки: ${deliveryTimes[counter]}</h4>
                    </div>
                    <div class="col-sm-6">
                        <div id="collapse${company.id}" aria-expanded="false" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                            <h4 class="font-weight-normal">Телефон: ${company.telephone} </h4>
                            <h4 class="font-weight-normal">Адрес: ${company.address} </h4>
                            <h4 class="font-weight-normal">Мэил: ${company.mail} </h4>
                        </div>
                    </div>
                    <div class="col-sm-1">
                        <div class="btn-group-vertical h-100 mr-1">
                            <button class="btn btn-link text-secondary" data-toggle="collapse" data-target="#collapse${company.id}" aria-expanded="true" aria-controls="collapseOne">
                                <h4>Подробнее</h4>
                            </button>
                            <a href="/addCompanyToDelivery/${company.id}" class="btn btn-link text-secondary"><h4>Выбрать</h4></a>
                        </div>
                    </div>
                </div>
                <#assign counter = counter + 1>
            </div>
        </div>
    </#list>

    <script defer>

        function twoFunc () {
            document.getElementById('input1').style.display="none";
        }
        document.getElementById('input1').addEventListener('click', twoFunc, false);

    </script>

</@c.page>

