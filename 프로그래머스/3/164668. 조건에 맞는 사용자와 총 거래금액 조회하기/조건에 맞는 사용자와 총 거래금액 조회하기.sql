select u.user_id, 
    u.nickname, 
    sum(b.price) as total_sales from used_goods_board as b join used_goods_user as u
        on b.writer_id = u.user_id
where b.status = 'done'
group by b.writer_id
having total_sales >= 700000
order by total_sales