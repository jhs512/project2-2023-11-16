<button class="btn btn-primary" on:click={hello}>버튼</button>

<script>
    function hello() {
        fetch('http://localhost:8010/api/v1/articles')
            .then(res => res.json())
            .then(res => console.log(res))
    }
</script>