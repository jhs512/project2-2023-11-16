<script>
    import {onMount} from 'svelte';

    let articles = [];
    let error = null;

    async function fetchArticles() {
        try {
            const response = await fetch('http://localhost:8010/api/v1/articles');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            articles = data.data.items;
        } catch (err) {
            error = err.message;
        }
    }

    onMount(fetchArticles);
</script>

{#if error}
    <p class="error">Error: {error}</p>
{:else}
    <ul>
        {#each articles as article}
            <li>
                <strong>{article.title}</strong>: {article.body}
            </li>
        {/each}
    </ul>
{/if}