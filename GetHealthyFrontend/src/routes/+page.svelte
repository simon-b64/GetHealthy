<script lang="ts">
    import {
        Button,
        Card,
        Progressbar,
        Span,
        Table,
        TableBody,
        TableBodyCell,
        TableBodyRow,
        TableHead,
        TableHeadCell
    } from 'flowbite-svelte';
    import type { DayEntry } from '$lib/model/DayEntry';
    import type { CalorieEntry } from '$lib/model/CalorieEntry';
    import { TimeUtils } from '$lib/time.utils';

    const data = {
        calorieGoal: 2800,
        carbohydratesGoal: 800,
        proteinGoal: 200,
        fatGoal: 20,
        entries: [
            {
                amount: 100,
                timestamp: new Date()
            },
            {
                amount: 100,
                timestamp: new Date()
            },
            {
                amount: 100,
                timestamp: new Date()
            },
            {
                amount: 100,
                timestamp: new Date()
            }
        ]
    } as DayEntry;

    const eaten = $derived(data.entries.map((value) => value.amount).reduce((previousValue, currentValue) => previousValue + currentValue));
    const burned = 0;
    const remaining = $derived(data.calorieGoal - eaten + burned);

    const carbohydrateProgress = $derived(calculateProgress((entry) => entry.carbohydrates, data.carbohydratesGoal));
    const proteinProgress = $derived(calculateProgress((entry) => entry.protein, data.proteinGoal));
    const fatProgress = $derived(calculateProgress((entry) => entry.fat, data.fatGoal));

    function calculateProgress(getter: (entry: CalorieEntry) => number | undefined, goal: number): number {
        const entries = data.entries.map(getter).filter((value) => value != null);

        if (entries.length === 0) {
            return 0;
        }

        return entries.reduce((previousValue, currentValue) => previousValue + currentValue) / goal;
    }
</script>

<svelte:head>
    <title>Tracking</title>
    <meta name="description" content="Calorie tracker" />
</svelte:head>

<section class="tracking-section flex flex-col gap-4">
    <Card class="m-auto">
        <div class="flex flex-col gap-4">
            <div class="flex justify-between">
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span class="text-xl">{eaten}</Span>
                    <Span class="text-xl">Eaten</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span class="text-xl">{remaining}</Span>
                    <Span class="text-xl">Remaining</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Span class="text-xl">{burned}</Span>
                    <Span class="text-xl">Burned</Span>
                </div>
            </div>
            <div class="flex justify-between">
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar size="h-4" progress={carbohydrateProgress} labelOutside=" " />
                    <Span class="text-xl">Carbs</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar size="h-4" progress={proteinProgress} labelOutside=" " />
                    <Span class="text-xl">Protein</Span>
                </div>
                <div class="flex w-1/4 flex-col items-center justify-center">
                    <Progressbar size="h-4" progress={fatProgress} labelOutside=" " />
                    <Span class="text-xl">Fat</Span>
                </div>
            </div>
        </div>
    </Card>
    <Table striped>
        <TableHead>
            <TableHeadCell>Timestamp</TableHeadCell>
            <TableHeadCell>Calories</TableHeadCell>
            <TableHeadCell>
                <span class="sr-only">Edit</span>
            </TableHeadCell>
        </TableHead>
        <TableBody tableBodyClass="divide-y">
            {#each data.entries as entry (entry.timestamp)}
                <TableBodyRow>
                    <TableBodyCell>{TimeUtils.formatTime(entry.timestamp)}</TableBodyCell>
                    <TableBodyCell>{entry.amount}</TableBodyCell>
                    <TableBodyCell>
                        <Button>Edit</Button>
                    </TableBodyCell>
                </TableBodyRow>
            {/each}
        </TableBody>
    </Table>
    <Button class="absolute right-2 bottom-20">Add</Button>
</section>

<style>
    .tracking-section {
        padding: 0.5rem;
    }
</style>
