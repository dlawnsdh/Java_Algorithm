select distinct o1.user_id, o1.product_id 
from online_sale as o1, online_sale as o2
where o1.user_id = o2.user_id
    and o1.product_id = o2.product_id
    and o1.sales_date != o2.sales_date
order by o1.user_id, o1.product_id desc;
