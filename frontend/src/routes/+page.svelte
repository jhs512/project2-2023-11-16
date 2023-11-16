<script>
    let articles = [];

    function fetchArticles() {
        fetch('http://localhost:8010/api/v1/articles')
            .then(res => res.json())
            .then(res => {
                articles = res.data.items;
            });
    }
</script>

<button class="btn btn-primary" on:click={fetchArticles}>게시물 불러오기</button>

<ul>
    {#each articles as article}
        <li>
            <strong>{article.title}</strong>: {article.body}
        </li>
    {/each}
</ul>