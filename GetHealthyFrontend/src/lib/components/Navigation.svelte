<script lang="ts">
    import { page } from '$app/state';
    import { BottomNav, BottomNavItem } from 'flowbite-svelte';
    import { AdjustmentsVerticalOutline, CalendarMonthSolid, HomeSolid } from 'flowbite-svelte-icons';

    const activeUrl = $derived(page.url.pathname);
</script>

<nav>
    <BottomNav {activeUrl} position="absolute" classInner="grid-cols-3">
        <BottomNavItem btnName="Tracking" href="/">
            <HomeSolid class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400" />
        </BottomNavItem>
        <BottomNavItem btnName="Calendar" href="/overview">
            <CalendarMonthSolid class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400" />
        </BottomNavItem>
        <BottomNavItem btnName="Settings" href="/settings">
            <AdjustmentsVerticalOutline class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400" />
        </BottomNavItem>
<!--        <BottomNavItem btnName="Profile">-->
<!--            <UserCircleSolid class="group-hover:text-primary-600 dark:group-hover:text-primary-500 mb-1 h-6 w-6 text-gray-500 dark:text-gray-400" />-->
<!--        </BottomNavItem>-->
    </BottomNav>
</nav>
